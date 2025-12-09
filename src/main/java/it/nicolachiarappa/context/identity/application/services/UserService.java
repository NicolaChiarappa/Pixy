package it.nicolachiarappa.context.identity.application.services;

import it.nicolachiarappa.context.identity.application.responses.LoginResponse;
import it.nicolachiarappa.context.identity.application.dtos.BaseUserDTO;
import it.nicolachiarappa.context.identity.application.requests.SignUpRequest;
import it.nicolachiarappa.context.identity.application.requests.LoginRequest;

public interface UserService {

    LoginResponse logIn(LoginRequest request);

    BaseUserDTO signUp(SignUpRequest request);




}
