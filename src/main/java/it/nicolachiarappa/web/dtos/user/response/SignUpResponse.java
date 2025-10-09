package it.nicolachiarappa.web.dtos.user.response;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public final class SignUpResponse extends UserResponse {


    Long id;

    String username;

    @Email
    String email;

}
