package deliveryservicesample.common;


import deliveryservicesample.FoodStoreApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FoodStoreApplication.class })
public class CucumberSpingConfiguration {
    
}
