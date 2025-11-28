package it.nicolachiarappa.context.community.domain.model;

import it.nicolachiarappa.context.identity.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    Long id;

    @OneToOne
    User author;

    @Column
    Integer vote;

    @Column
    String title;

    @Column
    String description;



}
