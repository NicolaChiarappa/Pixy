package it.nicolachiarappa.controller;


import it.nicolachiarappa.DTOs.UserDTO;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.service.UserService;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public UserDTO getUserById(@RequestParam(name = "id", required = true) Long id){
        return userService.getUserById(id);
    }

    @GetMapping({"/{username}"})
    public UserDTO getUserByUsername(@PathVariable(value = "username") String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public void saveUser(UserDTO dto){
        userService.saveUser(dto);
    }

}
