package net.skillfactory.springPractice.services;

import net.skillfactory.springPractice.configurations.Config;
import net.skillfactory.springPractice.dtos.UserDto;
import net.skillfactory.springPractice.exceptions.DuplicatedDniException;
import net.skillfactory.springPractice.exceptions.UserNotExistException;
import net.skillfactory.springPractice.models.User;
import net.skillfactory.springPractice.projections.UserProjection;
import net.skillfactory.springPractice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    private Config configuration;

    @Value("${user.countrycode}")
    private String countryCode;

    @Autowired
    public UserService(UserRepository userRepository, Config configuration){
        this.userRepository = userRepository;
        this.configuration = configuration;
    }

    public void add(User user) {

        if (!userRepository.findByDni(user.getDni()).isPresent()) {
            user.setCountryCode(countryCode);
            userRepository.save(user);
        } else {
            throw new DuplicatedDniException(String.format("The user couldn't be added, DNI: %s already exists", user.getDni()));
        }
    }

    public List<UserProjection> getAll() {
        return userRepository.findAllUsers();
    }

    public UserProjection getByDni(String dni) {
        return userRepository.findByDni(dni)
                .orElseThrow(() -> new UserNotExistException(String.format("The user with DNI: %s doesn't exists", dni)));
    }

    public void update(User user, String dni) {

        if((userRepository.findByDni(user.getDni()).isPresent())){ //todo fijarse como hacer para que no se compare a el mismo
            throw new DuplicatedDniException(String.format("The user can't be updated, new DNI: %s already exists", user.getDni()));
        }

        Integer idUser = userRepository.getIdByDni(dni)
                .orElseThrow(() -> new UserNotExistException(String.format("The user with DNI: %s doesn't exists", dni)));

        user.setId(idUser);
        userRepository.save(user);
    }


    public void partialUpdate(UserDto userDto, String dni) {

        if(userRepository.findByDni(userDto.getDni()).isPresent()){
            throw new DuplicatedDniException(String.format("The user can't be updated, new DNI: %s already exists", userDto.getDni()));
        }

        Integer idUser = userRepository.getIdByDni(dni)
                .orElseThrow(() -> new UserNotExistException(String.format("The user with DNI: %s doesn't exists", dni)));

        User newUser = configuration.getNewUser();
        Optional.ofNullable(userDto.getName()).ifPresent(newUser::setName);
        Optional.ofNullable(userDto.getLastName()).ifPresent(newUser::setLastName);
        Optional.ofNullable(userDto.getDni()).ifPresent(newUser::setDni);
        Optional.ofNullable(userDto.getAge()).ifPresent(newUser::setAge);
        Optional.ofNullable(userDto.getCountryCode()).ifPresent(newUser::setCountryCode);

        newUser.setId(idUser);
        userRepository.save(newUser);
    }
}
