package it.nicolachiarappa.context.compatibility.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Gear;
import it.nicolachiarappa.context.compatibility.domain.models.CompatibilityResult;

public interface EvaluatorNode<T extends Gear> {

    void doEvaluate(T firstGear, Gear secondGear, CompatibilityResult result);

}
