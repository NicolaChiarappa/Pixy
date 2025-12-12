package it.nicolachiarappa.context.compatibility.domain.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Collections;
import java.util.Set;

@Data
public class CompatibilityResult {

    @Setter(AccessLevel.NONE)
    private  CompatibilityType type;
    @Setter(AccessLevel.NONE)
    private  Set<CompatibilityLimitations> limitations;

    private CompatibilityResult(CompatibilityType type, Set<CompatibilityLimitations> limitations){
        this.type = type;
        this.limitations = limitations;
    }

    public static CompatibilityResult withLimitations(CompatibilityLimitations... limitations){
        return new CompatibilityResult(CompatibilityType.LIMITATIONS, Set.of(limitations));
    }

    public static CompatibilityResult compatible(){
        return new CompatibilityResult(CompatibilityType.COMPATIBLE, Collections.emptySet());
    }

    public static CompatibilityResult incompatible(){
        return new CompatibilityResult(CompatibilityType.INCOMPATIBLE, Collections.emptySet());
    }

    public static CompatibilityResult empty(){
        return new CompatibilityResult(null, null);
    }

    public void turnInto(CompatibilityResult result){
        this.type = result.getType();
        this.limitations = result.getLimitations();
    }


}
