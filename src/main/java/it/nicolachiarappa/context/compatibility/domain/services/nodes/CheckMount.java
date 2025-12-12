package it.nicolachiarappa.context.compatibility.domain.services.nodes;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Gear;
import it.nicolachiarappa.context.compatibility.domain.models.CompatibilityLimitations;
import it.nicolachiarappa.context.compatibility.domain.models.CompatibilityResult;
import it.nicolachiarappa.context.compatibility.domain.services.EvaluatorNode;
import lombok.Data;


import java.util.Collections;

@Data
public class CheckMount implements EvaluatorNode<Camera> {


    @Override
    public void doEvaluate(Camera firstGear, Gear secondGear, CompatibilityResult result) {
        if (!Collections.disjoint(firstGear.getMounts(), secondGear.getMounts())) {
            result.turnInto(CompatibilityResult.compatible());
        }
        else{
            result.turnInto(CompatibilityResult.withLimitations(CompatibilityLimitations.DIGITAL_CONTROLS));
        }
    }

}
