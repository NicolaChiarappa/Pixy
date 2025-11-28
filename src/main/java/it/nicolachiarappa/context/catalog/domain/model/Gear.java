package it.nicolachiarappa.context.catalog.domain.model;
import it.nicolachiarappa.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Gear  extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "manufacturer")
    private Manufacturer manufacturer;

    @Column
    private String name;

    @ManyToMany
    @Enumerated(EnumType.STRING)
    private Set<Mount> mounts;

    @Column
    private Date releaseDate;

    @Column
    private Double actualMarketValue;

    @Column
    @Enumerated(EnumType.STRING)
    private Status marketStatus;

}
