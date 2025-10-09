package it.nicolachiarappa.web.dtos.user.request;


public sealed abstract class UserRequest permits SignUpRequest, UpdateUserRequest  {
}
