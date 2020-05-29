package net.skillfactory.springPractice.controllers;

import net.skillfactory.springPractice.dtos.UserDto;
import net.skillfactory.springPractice.projections.UserProjection;
import net.skillfactory.springPractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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
    public ResponseEntity<?> add(@RequestBody UserDto userDto){
        userService.add(userDto);
        return ResponseEntity.created(URI.create("localhost:8081")).body("Added successfully");
    }

    @GetMapping("")
    public ResponseEntity<List<UserProjection>> getAll(){

        List<UserProjection> users = userService.getAll();
        return (users.size() > 0) ? ResponseEntity.ok(users) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<UserProjection> getByDni(@PathVariable(value = "dni") String dni){
        return ResponseEntity.ok(userService.getByDni(dni));
    }

    //todo Put and Patch updates
}
