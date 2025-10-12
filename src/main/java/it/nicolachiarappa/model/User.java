package it.nicolachiarappa.model;

import java.util.Date;
import jakarta.persistence.*;
import lombok.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "users")
public class User extends BaseAccount{


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;


    @Column(name = "birthDate")
    private Date birthDate;



//TODO:
//    @Column(name = "country")
//    private Country country;


    @Column(name = "gender")
    private Gender gender;


// TODO:
//    @OneToMany()
//    private List<Shop> shopsList;
//    @OneToMany()
//    private List<Review> reviewList;


}
