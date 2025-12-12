package it.nicolachiarappa.context.compatibility.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Gear;
import it.nicolachiarappa.context.catalog.domain.models.Lens;
import it.nicolachiarappa.context.compatibility.domain.services.nodes.CheckMount;

import java.util.LinkedHashSet;

public class CameraChainFactory {


    private static EvaluatorChain<Camera> getDefaultLens(){
        LinkedHashSet<EvaluatorNode<Camera>> nodes = new LinkedHashSet<>();
        EvaluatorChain<Camera> chain = new EvaluatorChain<>(nodes);

        chain.addNodeAfter(null, new CheckMount());
        return chain;
    }




    public static EvaluatorChain<Camera> getChainFrom(Gear gear){
        return switch (gear){
            case Lens ignored -> getDefaultLens();
            default -> throw new IllegalArgumentException();
        };
    }

}
