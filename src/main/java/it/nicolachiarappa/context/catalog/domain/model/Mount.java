package it.nicolachiarappa.context.catalog.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public enum Mount {

    SONY_E, SONY_FE;


    @Id
    @Getter
    @Setter
    private Long id;

}
