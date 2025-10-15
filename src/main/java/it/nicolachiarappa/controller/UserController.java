package it.nicolachiarappa.controller;
import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService service){
        this.userService = service;
    }

    @GetMapping("/{id}")
    public BaseUserDTO getUserById(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<BaseUserDTO> getUserByUsername(@RequestParam(value = "username", required = false ) String username){
        System.out.println(username);
        if(username.isEmpty()){
            return userService.getAll();
        }
        return List.of(userService.getUserByUsername(username));
    }



    @PostMapping
    public BaseUserDTO addUser(@RequestBody SignUpRequest dto){
        return userService.saveUser(dto);
    }

    @PostMapping("/many")
    public List<BaseUserDTO> addMany(@RequestBody List<SignUpRequest> requests){
        return userService.saveMany(requests);
    }


    @PatchMapping("/{id}")
    public BaseUserDTO updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id, request);
    }



}
