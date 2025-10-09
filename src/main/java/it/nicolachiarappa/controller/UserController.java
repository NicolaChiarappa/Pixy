package it.nicolachiarappa.controller;


import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.mapper.UserMapper;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.web.dtos.user.response.SignUpResponse;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private UserService userService;


    @Autowired
    public UserController(UserService service){
        this.userService = service;
    }

    @GetMapping
    public BaseUserDTO getUserById(@RequestParam(name = "id", required = true) Long id){
        return userService.getUserById(id);
    }

    @GetMapping({"/{username}"})
    public BaseUserDTO getUserByUsername(@PathVariable(value = "username") String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public BaseUserDTO addUser(@RequestBody SignUpRequest dto){
        return userService.saveUser(dto);
    }

    @PatchMapping("/update")
    public BaseUserDTO updateUser(@RequestBody UpdateUserRequest request){
        return userService.updateUser(request);
    }

}
