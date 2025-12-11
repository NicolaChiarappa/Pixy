package it.nicolachiarappa.context.catalog.domain.models;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@NoArgsConstructor
public class FocalLength {

    public FocalLength(Integer minimumLength, Integer maximumLength){
        if(minimumLength>maximumLength){
            throw new IllegalArgumentException();
        }
        this.minimumLength=minimumLength;
        this.maximumLength=maximumLength;
        if(minimumLength.equals(maximumLength)){
            isFixed=true;
        }
    }

    public FocalLength(Integer fixedLength){
        new FocalLength(fixedLength, fixedLength);
    }


    private Integer minimumLength;

    private Integer maximumLength;

    @Setter(AccessLevel.NONE)
    private Boolean isFixed;

}
