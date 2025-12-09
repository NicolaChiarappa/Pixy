package it.nicolachiarappa.context.identity.application.mappers;

import it.nicolachiarappa.context.identity.application.dtos.BaseUserDTO;
import it.nicolachiarappa.context.identity.application.requests.LoginRequest;
import it.nicolachiarappa.context.identity.application.requests.SignUpRequest;
import it.nicolachiarappa.context.identity.application.utilities.PasswordHelper;
import it.nicolachiarappa.context.identity.domain.models.User;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses={PasswordHelper.class}
)
public interface UserMapper {




    BaseUserDTO toDto(User user);


    @Mapping(target = "passwordHash", source = "password", qualifiedByName = "encodePassword")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "gender", source = "gender")
    User fromSignUp(@NotNull SignUpRequest request);


    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "photoUrl", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    User fromLogin(LoginRequest request);


}
