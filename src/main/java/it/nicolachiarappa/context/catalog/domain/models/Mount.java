package it.nicolachiarappa.context.catalog.domain.models;

import it.nicolachiarappa.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Mount extends BaseEntity {

    @Column
    private String name;

    @Column
    private String slug;

}
