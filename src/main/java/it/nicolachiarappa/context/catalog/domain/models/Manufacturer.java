package it.nicolachiarappa.context.catalog.domain.models;

import it.nicolachiarappa.shared.domain.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "manufacturers", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Manufacturer extends BaseEntity {

    @Column
    private String name;

}
