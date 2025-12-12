package it.nicolachiarappa.context.compatibility.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Gear;
import it.nicolachiarappa.context.compatibility.domain.models.CompatibilityResult;

public interface CompatibilityEvaluator<T extends Gear> {

    CompatibilityResult evaluate(T mainGear, Gear toEvaluate);


}
