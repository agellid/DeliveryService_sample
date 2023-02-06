package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class StoreHateoasProcessor implements RepresentationModelProcessor<EntityModel<Store>>  {

    @Override
    public EntityModel<Store> process(EntityModel<Store> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/orderreject").withRel("orderreject"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cookbegin").withRel("cookbegin"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cookend").withRel("cookend"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/deliveryrequest").withRel("deliveryrequest"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/orderaccept").withRel("orderaccept"));

        
        return model;
    }
    
}
