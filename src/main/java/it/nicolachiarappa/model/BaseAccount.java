package it.nicolachiarappa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "role")
    @NonNull
    private AccountRole role;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "photoURL")
    private String photoURL;

    @Email
    @Column(name = "email")
    @NonNull
    private String email;


    public BaseAccount() {

    }
}
