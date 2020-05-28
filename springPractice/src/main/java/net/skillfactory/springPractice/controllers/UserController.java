package net.skillfactory.springPractice.controllers;

import net.skillfactory.springPractice.dtos.UserDto;
import net.skillfactory.springPractice.models.User;
import net.skillfactory.springPractice.projections.UserProjection;
import net.skillfactory.springPractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public void add(@RequestBody UserDto userDto){
        userService.add(userDto);
    }

    @GetMapping("")
    public List<UserProjection> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{dni}")
    public UserProjection getByDni(@PathVariable(value = "dni") String dni){
        return userService.getByDni(dni);
    }
}
