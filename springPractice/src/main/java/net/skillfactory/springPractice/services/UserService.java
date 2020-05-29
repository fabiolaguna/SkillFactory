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

    public void add(UserDto userDto) {

        if (userRepository.existsByDni(userDto.getDni()) == null) {
            User user = configuration.getNewUser();
            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setAge(userDto.getAge());
            user.setDni(userDto.getDni());
            user.setCountryCode(countryCode);

            userRepository.save(user);
        } else {
            throw new DuplicatedDniException(String.format("The user couldn't be added, DNI: %s already exists", userDto.getDni()));
        }

    }

    public List<UserProjection> getAll() {
        return userRepository.findAllUsers();
    }

    public UserProjection getByDni(String dni) {
        return userRepository.findByDni(dni)
                .orElseThrow(() -> new UserNotExistException(String.format("The user with DNI: %s doesn't exists", dni)));
    }

}
