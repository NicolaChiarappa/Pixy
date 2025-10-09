package it.nicolachiarappa.web.mapper;

import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {



    BaseUserDTO toDto(User user);


    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "photoUrl", source ="user.photoUrl" )
    @Mapping(target = "birthDate", source = "user.birthDate")
    @Mapping(target = "gender", source = "user.gender")
    @Mapping(target = "name", source = "user.name")
    User fromSignUp(SignUpRequest request);


    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "photoUrl", source ="photoUrl" )
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "name", source = "name")
    User fromUpdate(@MappingTarget User existing, UpdateUserRequest request);



}
