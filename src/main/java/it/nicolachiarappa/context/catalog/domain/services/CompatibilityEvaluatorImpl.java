package it.nicolachiarappa.context.catalog.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Lens;
import it.nicolachiarappa.context.catalog.domain.models.Mount;

import java.util.HashSet;

public class CompatibilityEvaluatorImpl implements CompatibilityEvaluator{
    @Override
    public CompatibilityResult evaluate(Camera camera, Lens lens) {
        HashSet<Mount> intersection = new HashSet<>(camera.getMounts());
        intersection.retainAll(lens.getMounts());
        if (!intersection.isEmpty()){
            return CompatibilityResult.compatible();
        }else {
            if((long) camera.getMounts().size() >1){
                CompatibilityResult result =  CompatibilityResult.withLimitations(CompatibilityLimitations.REQUIRE_ADAPTER);
                System.out.println(result);
                return result;
            }
        }

        return CompatibilityResult.incompatible();
    }
}
