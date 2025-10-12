package it.nicolachiarappa.web.dtos.user.request;

import it.nicolachiarappa.model.Gender;
import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import lombok.*;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public final class SignUpRequest extends UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Date birthDate;
    private String password;
    private Gender gender;

}
