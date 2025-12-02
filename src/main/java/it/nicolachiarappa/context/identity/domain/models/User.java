package it.nicolachiarappa.context.identity.domain.models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(name = "email", columnNames = {"email"}),
            @UniqueConstraint(name = "username", columnNames = {"username"})
        }
    )
public class User extends BaseAccount{

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date birthDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "gender")
    private Gender gender;




}
