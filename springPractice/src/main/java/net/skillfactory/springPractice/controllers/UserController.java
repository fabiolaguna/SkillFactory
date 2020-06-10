package net.skillfactory.springPractice.controllers;

import net.skillfactory.springPractice.dtos.UserDto;
import net.skillfactory.springPractice.models.User;
import net.skillfactory.springPractice.projections.UserProjection;
import net.skillfactory.springPractice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public ResponseEntity<String> add(@RequestBody @Valid User user){
        userService.add(user);
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

    @PutMapping("/{dni}")  // Receive an User and not an UserDto because the "@NotNull" validations
    public ResponseEntity<UserDto> update(@RequestBody @Valid User user, @PathVariable(value = "dni") String dni){
        userService.update(user, dni);
        UserDto userDto = UserDto.builder().name(user.getName()).lastName(user.getLastName()).dni(user.getDni()).age(user.getAge()).countryCode(user.getCountryCode()).build();
        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/{dni}")
    public ResponseEntity<UserDto> partialUpdate(@RequestBody @Valid UserDto userDto, @PathVariable(value = "dni") String dni){
        return ResponseEntity.ok(userService.partialUpdate(userDto, dni));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<String> delete(@PathVariable(value = "dni") String dni){
        userService.delete(dni);
        return ResponseEntity.ok("Deleted successfully");
    }
}
