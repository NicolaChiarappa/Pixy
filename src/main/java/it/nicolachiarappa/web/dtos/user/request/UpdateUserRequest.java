package it.nicolachiarappa.web.dtos.user.request;

import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class UpdateUserRequest extends UserRequest{

    /**
     * User's id who you want to update
     */
    private Long id;

    /**
     * Payload of the new properties that you want to edit
     */
    private BaseUserDTO newUser;

}
