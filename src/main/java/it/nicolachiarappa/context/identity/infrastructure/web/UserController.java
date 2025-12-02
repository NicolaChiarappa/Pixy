package it.nicolachiarappa.context.identity.infrastructure.web;
import it.nicolachiarappa.context.identity.application.dtos.BaseUserDTO;
import it.nicolachiarappa.context.identity.application.requests.LoginRequest;
import it.nicolachiarappa.context.identity.application.requests.SignUpRequest;
import it.nicolachiarappa.context.identity.application.responses.LoginResponse;
import it.nicolachiarappa.context.identity.application.services.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserServiceImpl userService;
    private final ApiResponseFactory factory;


    @Autowired
    public UserController(UserServiceImpl service, ApiResponseFactory factory){
        this.userService = service;
        this.factory = factory;

    }
//
//    @GetMapping("/{id}")
//    public ApiResponse<BaseUserDTO> getUserById(@PathVariable(name = "id") Long id){
//        return factory.createSuccessResponse(
//                Messages.Success.ACCOUNT_FOUND,
//                userService.getUserById(id)
//        );
//    }
//
//    @GetMapping("/all")
//    public ApiResponse<List<BaseUserDTO>> getAllUsers(){
//        return factory.createSuccessResponse(
//                Messages.Success.ACCOUNT_FOUND,
//                userService.getAll()
//        );
//
//
//    }
//
//    @GetMapping
//    public ApiResponse<BaseUserDTO> getByUsername(@RequestParam(value = "username" ) String username){
//        return factory.createSuccessResponse(
//                Messages.Success.ACCOUNT_FOUND,
//                userService.getUserByUsername(username)
//        );
//    }




    @PostMapping("/signup")
    public ApiResponse<BaseUserDTO> signUp(@RequestBody @Valid SignUpRequest dto){
        return factory.createSuccessResponse(
                Messages.Success.ACCOUNT_CREATED,
                userService.signUp(dto)
        );
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        return factory.createSuccessResponse(
                Messages.Success.USER_LOGGED_IN,
                userService.logIn(request)
        );
    }




//    @PatchMapping("/{id}")
//    public ApiResponse<BaseUserDTO> updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserRequest request){
//        return factory.createSuccessResponse(
//                Messages.Success.ACCOUNT_MODIFIED,
//                userService.updateUser(id, request)
//        );
//    }
}
