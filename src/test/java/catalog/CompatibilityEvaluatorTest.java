package catalog;

import it.nicolachiarappa.context.catalog.domain.models.Camera;
import it.nicolachiarappa.context.catalog.domain.models.Lens;
import it.nicolachiarappa.context.catalog.domain.models.Mount;
import it.nicolachiarappa.context.catalog.domain.services.CompatibilityEvaluator;
import it.nicolachiarappa.context.catalog.domain.services.CompatibilityEvaluatorImpl;
import it.nicolachiarappa.context.catalog.domain.services.CompatibilityResult;
import it.nicolachiarappa.context.catalog.domain.services.CompatibilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.random.RandomGenerator;

public class CompatibilityEvaluatorTest {

    Camera camera;
    Lens lens;
    CompatibilityEvaluator evaluator = new CompatibilityEvaluatorImpl();
    RandomGenerator generator = RandomGenerator.getDefault();


    @BeforeEach
    public void setUp(){

        camera = new Camera();
        camera.setId(generator.nextLong());
        camera.setName("camera");
        camera.setMounts(Set.of(Mount.SONY_E));

        lens = new Lens();
        lens.setId(generator.nextLong());
        lens.setName("lens");
        lens.setMounts(Set.of(Mount.SONY_E, Mount.SONY_FE));

    }

    @Test
    public void shouldBeCompatibleWhenMountsMatch(){
        CompatibilityResult result = evaluator.evaluate(camera,lens);

        Assertions.assertEquals(result.getType(), CompatibilityType.COMPATIBLE );
    }


}
