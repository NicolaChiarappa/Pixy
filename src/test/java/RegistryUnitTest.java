import it.nicolachiarappa.context.catalog.domain.models.*;
import it.nicolachiarappa.context.identity.domain.models.User;
import it.nicolachiarappa.context.identity.infrastructure.security.SpringJWTHelper;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;


public class RegistryUnitTest {

    RandomGenerator generator = RandomGeneratorFactory.getDefault().create();

    SpringJWTHelper helper = new SpringJWTHelper();

    @Test
    public void successUpgradeCamera(){

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Sony");

        Camera camera = new Camera();
        camera.setName("firstCamera");
        camera.setOutOfProduction();
        camera.setReleaseDate(Date.from(Instant.EPOCH));
        camera.setManufacturer(manufacturer);

        Camera second = new Camera();
        second.setReleaseDate(Date.from(Instant.now()));
        second.setMarketStatus(Status.ACTIVE);
        second.setManufacturer(manufacturer);

        camera.upgrade(second);

        Assertions.assertEquals(camera.getSuccessor(), second);

    }

   @Test
    public void failUpgradeCamera(){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Sony");

        Camera camera = new Camera();
        camera.setName("firstCamera");
        camera.setOutOfProduction();
        camera.setReleaseDate(Date.from(Instant.EPOCH));
        camera.setManufacturer(manufacturer);

        Camera second = new Camera();
        second.setReleaseDate(Date.from(Instant.now()));
        second.setMarketStatus(Status.ACTIVE);
        second.setManufacturer(manufacturer);

        camera.upgrade(second);

        Assertions.assertThrows(IllegalArgumentException.class, ()->second.upgrade(camera));

    }


    @Test
    public void failLensUpgrade(){
        Lens oldLens= new Lens();
        Lens newLens = new Lens();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        validator.validate(oldLens);
        validator.validate(newLens);


        oldLens.setId(generator.nextLong());
        newLens.setId(generator.nextLong());

//        Assertions.assertNotEquals(oldLens, newLens);
//
//        Focal lensFocal = new Focal();
//
//        lensFocal.setMaximumLength(10);
//        lensFocal.setMinimumLength(5);
//
//        oldLens.setFocal(lensFocal);
//
//        Focal secondFocal= new Focal();
//        secondFocal.setMinimumLength(5);
//        secondFocal.setMaximumLength(15);
//
//        Assertions.assertThrows(IllegalArgumentException.class, ()->oldLens.upgrade(newLens));
    }

@Test
    public void getJWT(){
        User user = new User();
        user.setId(1L);
        user.setFirstName("nicola");
        String token = helper.generate(user,1);

        System.out.println(token);
        System.out.println();
    }


}
