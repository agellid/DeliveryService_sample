package deliveryservicesample.common;


import deliveryservicesample.SmsApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { SmsApplication.class })
public class CucumberSpingConfiguration {
    
}
