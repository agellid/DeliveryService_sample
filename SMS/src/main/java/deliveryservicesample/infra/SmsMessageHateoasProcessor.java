package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class SmsMessageHateoasProcessor implements RepresentationModelProcessor<EntityModel<SmsMessage>>  {

    @Override
    public EntityModel<SmsMessage> process(EntityModel<SmsMessage> model) {

        
        return model;
    }
    
}
