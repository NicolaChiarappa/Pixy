//import it.nicolachiarappa.Main;
//import it.nicolachiarappa.context.catalog.application.requests.CreateManufacturerRequest;
//import it.nicolachiarappa.context.catalog.application.services.ManufacturerServiceImpl;
//import it.nicolachiarappa.context.catalog.domain.model.Manufacturer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//        classes = Main.class)
//
//@AutoConfigureMockMvc
//
//@TestPropertySource(
//        locations = "classpath:application.properties")
//
//public class TestService {
//
//
//    @Autowired
//    ManufacturerServiceImpl manufacturerService;
//
//
//    //==================================
//    //  Add Manufacturer section
//    //==================================
//
//    @Test
//    public void successAdd() {
//
//        CreateManufacturerRequest request = new CreateManufacturerRequest();
//        request.setName("Panasonic");
//
//        Manufacturer man = manufacturerService.addManufacturer(request);
//
//        Assertions.assertEquals(man.getName(), request.getName());
//
//    }
//
//    @Test
//    public void duplicatedKeyError(){
//        CreateManufacturerRequest request1 = new CreateManufacturerRequest();
//        CreateManufacturerRequest request2 = new CreateManufacturerRequest();
//        request1.setName("Sony");
//        request2.setName("Sony");
//
//        Manufacturer manufacturer = manufacturerService.addManufacturer(request1);
//
//
//        Assertions.assertThrows(DataIntegrityViolationException.class, ()->{
//            manufacturerService.addManufacturer(request2);
//        });
//    }
//
//
//
//
//
//
//
//
//}