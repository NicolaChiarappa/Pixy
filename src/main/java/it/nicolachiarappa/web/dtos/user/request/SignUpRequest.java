package it.nicolachiarappa.web.dtos.user.request;

import it.nicolachiarappa.context.identity.domain.model.Gender;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Email;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public final class SignUpRequest extends UserRequest {

    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String username;
    private Date birthDate;
    private String password;
    private Gender gender;
    @URL
    private String photoUrl;

}
