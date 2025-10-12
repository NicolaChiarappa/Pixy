package it.nicolachiarappa.controller;

import it.nicolachiarappa.model.User;
import it.nicolachiarappa.repository.UserRepository;
import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.service.UserService;
import it.nicolachiarappa.web.dtos.user.response.Response;
import it.nicolachiarappa.web.mapper.UserMapper;
import it.nicolachiarappa.web.mapper.UserMapperImpl;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService userService;

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(ConstraintViolationException ex) {
        Map<String, Object> body = new HashMap<>();

        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Validation failed");
        body.put("messages", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }


    @Autowired
    public UserController(UserService service, UserRepository userRepository, UserMapperImpl userMapperImpl){
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

    @PatchMapping
    public BaseUserDTO updateUser(@RequestParam(name = "id", required = true) Long id, @RequestBody UpdateUserRequest request){
        return userService.updateUser(id, request);
    }

    @GetMapping("/all")
    public List<BaseUserDTO> findMany(){
        ArrayList<BaseUserDTO> userList = new ArrayList();
        return userService.getAll();
    }

}
