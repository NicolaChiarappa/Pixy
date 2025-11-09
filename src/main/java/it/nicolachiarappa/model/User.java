package it.nicolachiarappa.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = false)
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



//TODO:
//  @Column
//  private Country country;


    @Column(name = "gender")
    private Gender gender;


// TODO:
//    @OneToMany()
//    private List<Shop> shopsList;
//    @OneToMany()
//    private List<Review> reviewList;


}
