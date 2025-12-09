package it.nicolachiarappa.context.catalog.domain.models;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Embeddable
@Data
public class Focal {

    public Focal (Integer minimumLength, Integer maximumLength){
        if(minimumLength>maximumLength){
            throw new IllegalArgumentException();
        }
        this.minimumLength=minimumLength;
        this.maximumLength=maximumLength;
        if(minimumLength.equals(maximumLength)){
            isFixed=true;
        }
    }

    public Focal(Integer fixedLength){
        new Focal(fixedLength, fixedLength);
    }


    public Focal(){

    }

    private Integer minimumLength;

    private Integer maximumLength;

    @Setter(AccessLevel.NONE)
    private Boolean isFixed;

}
