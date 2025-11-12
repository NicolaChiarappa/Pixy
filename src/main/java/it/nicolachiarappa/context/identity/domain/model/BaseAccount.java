package it.nicolachiarappa.context.identity.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "role")
    private AccountRole role;

    @Column(unique = true, name = "username")
    private String username;


    @Column(name = "photoUrl")
    private String photoUrl;

    @Email
    @Column(name = "email")
    private String email;

}
