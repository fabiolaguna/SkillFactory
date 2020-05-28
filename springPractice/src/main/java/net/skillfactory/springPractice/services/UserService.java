package net.skillfactory.springPractice.services;

import net.skillfactory.springPractice.dtos.UserDto;
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

    @Value("${user.countrycode}")
    private String countryCode;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void add(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setDni(userDto.getDni());
        user.setAge(userDto.getAge());
        user.setCountryCode(countryCode);

        userRepository.save(user);
    }

    public List<UserProjection> getAll() {
        return userRepository.findAllUsers();
    }

    public UserProjection getByDni(String dni) {

        return Optional.ofNullable(userRepository.findByDni(dni))
                .get()
                .orElseThrow(RuntimeException::new);

    }
}
