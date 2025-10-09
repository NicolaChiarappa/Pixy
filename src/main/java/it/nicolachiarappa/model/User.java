package it.nicolachiarappa.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "users")
public class User extends BaseAccount{


    @Column(name = "name")
    private String name;


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
