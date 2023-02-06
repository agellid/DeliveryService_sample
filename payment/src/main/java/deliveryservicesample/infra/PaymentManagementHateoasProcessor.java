package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PaymentManagementHateoasProcessor implements RepresentationModelProcessor<EntityModel<PaymentManagement>>  {

    @Override
    public EntityModel<PaymentManagement> process(EntityModel<PaymentManagement> model) {

        
        return model;
    }
    
}
