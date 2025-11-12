package it.nicolachiarappa.context.identity.infrastructure.web;
import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.context.identity.application.service.UserService;
import jakarta.validation.Valid;
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
                Messages.Success.ACCOUNT_FOUND,
                userService.getUserById(id)
        );
    }

    @GetMapping("/all")
    public ApiResponse<List<BaseUserDTO>> getAllUsers(){
        return factory.createSuccessResponse(
                Messages.Success.ACCOUNT_FOUND,
                userService.getAll()
        );


    }

    @GetMapping
    public ApiResponse<BaseUserDTO> getByUsername(@RequestParam(value = "username" ) String username){
        return factory.createSuccessResponse(
                Messages.Success.ACCOUNT_FOUND,
                userService.getUserByUsername(username)
        );
    }




    @PostMapping
    public ApiResponse<BaseUserDTO> addUser(@RequestBody @Valid SignUpRequest dto){
        return factory.createSuccessResponse(
                Messages.Success.ACCOUNT_CREATED,
                userService.saveUser(dto)
        );
    }




    @PatchMapping("/{id}")
    public ApiResponse<BaseUserDTO> updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequest request){
        return factory.createSuccessResponse(
                Messages.Success.ACCOUNT_MODIFIED,
                userService.updateUser(id, request)
        );
    }
}
