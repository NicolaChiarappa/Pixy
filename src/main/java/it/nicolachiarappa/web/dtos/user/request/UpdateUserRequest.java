package it.nicolachiarappa.web.dtos.user.request;

import it.nicolachiarappa.context.identity.domain.model.Gender;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public final class UpdateUserRequest extends UserRequest{

    private String firstName;

    private String lastName;

    private String username;

    private Date birthDate;

    @Email
    private String email;

    private Gender gender;

    @URL
    private String photoUrl;


}
