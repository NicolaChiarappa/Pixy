package it.nicolachiarappa.context.identity.application.requests;

import it.nicolachiarappa.context.identity.domain.models.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.Email;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public final class SignUpRequest extends UserRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String username;
    private Date birthDate;
    @NotNull
    private String password;
    private Gender gender;
    @URL
    private String photoUrl;

    private String role;

}
