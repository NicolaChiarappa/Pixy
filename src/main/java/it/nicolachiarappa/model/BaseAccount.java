package it.nicolachiarappa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.URL;

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

    @URL
    @Column(name = "photoUrl")
    private String photoUrl;

    @Email
    @Column(unique = true, name = "email")
    private String email;

}
