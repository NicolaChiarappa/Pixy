package it.nicolachiarappa.context.catalog.domain.models;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LensAdapter extends Gear{

    @Embedded
    private Mount source;

    @Embedded
    private Mount target;


}
