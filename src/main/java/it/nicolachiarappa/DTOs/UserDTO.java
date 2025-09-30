package it.nicolachiarappa.DTOs;

import it.nicolachiarappa.model.AccountRole;
import it.nicolachiarappa.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String name;

    @Max(value = 99)
    private int age;

    private Gender gender;

    @Email
    private String email;

    private AccountRole role;




}
