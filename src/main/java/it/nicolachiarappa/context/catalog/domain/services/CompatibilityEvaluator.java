package it.nicolachiarappa.context.catalog.domain.services;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Lens;

public interface CompatibilityEvaluator {

    CompatibilityResult evaluate(Camera camera, Lens lens);


}
