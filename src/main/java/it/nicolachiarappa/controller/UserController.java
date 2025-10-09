package it.nicolachiarappa.controller;

import it.nicolachiarappa.model.User;
import it.nicolachiarappa.repository.UserRepository;
import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.service.UserService;
import it.nicolachiarappa.web.mapper.UserMapper;
import it.nicolachiarappa.web.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private UserService userService;


    @Autowired
    public UserController(UserService service, UserRepository userRepository, UserMapperImpl userMapperImpl){
        this.userService = service;
        this.userRepository = userRepository;
        this.userMapper = userMapperImpl;
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

    @PatchMapping
    public BaseUserDTO updateUser(@RequestParam(name = "id", required = true) Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id, request);
    }

    @GetMapping("/all")
    public List<BaseUserDTO> findMany(){
        ArrayList<BaseUserDTO> userList = new ArrayList();
        for(User u : userRepository.findAll())
        {
            userList.add(userMapper.toDto(u));
        }
        return userList;
    }

}
