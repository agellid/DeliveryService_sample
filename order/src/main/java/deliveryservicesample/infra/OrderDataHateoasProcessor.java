package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class OrderDataHateoasProcessor implements RepresentationModelProcessor<EntityModel<OrderData>>  {

    @Override
    public EntityModel<OrderData> process(EntityModel<OrderData> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/ordercancel").withRel("ordercancel"));

        
        return model;
    }
    
}
