package it.nicolachiarappa.context.catalog.domain.services;

import lombok.Data;

import java.util.Collections;
import java.util.Set;

@Data
public class CompatibilityResult {

    private final CompatibilityType type;
    private final Set<CompatibilityLimitations> limitations;

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


}
