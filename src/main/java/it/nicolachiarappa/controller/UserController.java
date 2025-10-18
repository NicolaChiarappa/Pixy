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
    private final ApiResponseFactory factory;


    @Autowired
    public UserController(UserService service, ApiResponseFactory factory){
        this.userService = service;
        this.factory = factory;

    }

    @GetMapping("/{id}")
    public ApiResponse<BaseUserDTO> getUserById(@PathVariable(name = "id") Long id){
        return factory.createSuccessResponse(
                "user found",
                userService.getUserById(id)
        );
    }

    @GetMapping("/all")
    public ApiResponse<List<BaseUserDTO>> getAllUsers(){
        return factory.createSuccessResponse(
                "these are all the users",
                userService.getAll()
        );


    }

    @GetMapping
    public ApiResponse<BaseUserDTO> getByUsername(@RequestParam(value = "username" ) String username){
        return factory.createSuccessResponse(
                "user found",
                userService.getUserByUsername(username)
        );
    }




    @PostMapping
    public ApiResponse<BaseUserDTO> addUser(@RequestBody SignUpRequest dto){
        return factory.createSuccessResponse(
                "user created successfully",
                userService.saveUser(dto)
        );
    }

    @PostMapping("/many")
    public ApiResponse<List<BaseUserDTO>> addMany(@RequestBody List<SignUpRequest> requests){
        return factory.createSuccessResponse(
                "these are all the accounts created",
                userService.saveMany(requests)
        );
    }


    @PatchMapping("/{id}")
    public ApiResponse<BaseUserDTO> updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequest request){
        return factory.createSuccessResponse(
                "account modified successfully",
                userService.updateUser(id, request)
        );
    }



}
