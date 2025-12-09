package it.nicolachiarappa.context.identity.application.services;

import it.nicolachiarappa.context.identity.application.requests.LoginRequest;
import it.nicolachiarappa.context.identity.application.responses.LoginResponse;
import it.nicolachiarappa.context.identity.application.dtos.BaseUserDTO;
import it.nicolachiarappa.context.identity.application.requests.SignUpRequest;
import it.nicolachiarappa.context.identity.application.mappers.UserMapper;
import it.nicolachiarappa.context.identity.application.utilities.JWTHelper;
import it.nicolachiarappa.context.identity.application.utilities.PasswordHelper;
import it.nicolachiarappa.context.identity.domain.models.User;
import it.nicolachiarappa.context.identity.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper  userMapper;
    private final PasswordHelper passwordHandler;
    private final JWTHelper jwtHelper;

    @Autowired
    public UserServiceImpl(UserRepository repo, UserMapper mapper, PasswordHelper passHandler, JWTHelper jHelper ){
        userRepository= repo;
        userMapper = mapper;
        passwordHandler = passHandler;
        jwtHelper= jHelper;
    }

    @Override
    public LoginResponse logIn(LoginRequest request)  {
        User user = userMapper.fromLogin(request);
        user = userRepository.findByUsername(user.getUsername()).orElseThrow();
        if(passwordHandler.match(request.getPassword(), user.getPasswordHash())){
            return new LoginResponse(jwtHelper.generate(user, 1));
        }else {
            throw new UnsupportedOperationException("Invalid credentials");
        }

    }




    @Override
    public BaseUserDTO signUp(SignUpRequest request){
       User user = userMapper.fromSignUp(request);
       User saved = userRepository.save(user);
       return userMapper.toDto(saved);
    }



}
