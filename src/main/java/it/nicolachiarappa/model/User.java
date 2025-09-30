package it.nicolachiarappa.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "users")
public class User extends BaseAccount{

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;



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



public User( AccountRole role, String username, String name, @Email String email, int age, Gender gender){
    super( role, username, email);
    this.name = name;
    this.age = age;
    this.gender = gender;
}


    public User() {

    }
}
