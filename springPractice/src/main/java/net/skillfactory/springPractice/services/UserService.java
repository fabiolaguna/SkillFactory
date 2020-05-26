package net.skillfactory.springPractice.services;

import net.skillfactory.springPractice.models.User;
import net.skillfactory.springPractice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByDni(String dni) {

        return Optional.ofNullable(userRepository.findByDni(dni))
                .get()
                .orElseThrow(RuntimeException::new);

    }
}
