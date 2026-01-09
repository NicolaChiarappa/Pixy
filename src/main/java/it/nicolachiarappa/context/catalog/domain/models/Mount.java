package it.nicolachiarappa.context.catalog.domain.models;

import it.nicolachiarappa.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Mount extends BaseEntity {

    @Column
    private String name;

    @Column
    private String slug;

}
