package it.nicolachiarappa.web.dtos.user.request;

import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public final class SignUpRequest extends UserRequest {

    private BaseUserDTO user;

}
