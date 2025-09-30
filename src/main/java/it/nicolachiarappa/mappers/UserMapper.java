package it.nicolachiarappa.mappers;

import it.nicolachiarappa.DTOs.UserDTO;
import it.nicolachiarappa.model.AccountRole;
import it.nicolachiarappa.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {


    @Override
    public UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getAge(),
                user.getGender(),
                user.getEmail(),
                user.getRole()
        );

    }

    @Override
    public User toModel(UserDTO dto) {
        return new User(
                AccountRole.USER,
                dto.getUsername(),
                dto.getName(),
                dto.getEmail(),
                dto.getAge(),
                dto.getGender()
        );
    }
}
