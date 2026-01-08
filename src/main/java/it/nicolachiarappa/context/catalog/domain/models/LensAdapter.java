package it.nicolachiarappa.context.catalog.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class LensAdapter extends Gear{

    public LensAdapter(Mount source, Mount target){
        checkComplementary(source,target);
        this.source=source;
        this.target=target;
    }

    @Enumerated(EnumType.STRING)
    private Mount source;


    @Enumerated(EnumType.STRING)
    private Mount target;


    public void setSource(Mount source){
        checkComplementary(source, this.target);
        this.source=source;
    }

    public void setTarget(Mount target){
        checkComplementary(this.source, target);
        this.target=target;
    }


    private void checkComplementary(Mount source, Mount target){
        if(source!=null && target !=null){
            if(source.equals(target)){
                throw new IllegalArgumentException("Source and target mount must be the different");
            }
        }else{
            throw new NullPointerException("Target or source mount is null");
        }
    }


}
