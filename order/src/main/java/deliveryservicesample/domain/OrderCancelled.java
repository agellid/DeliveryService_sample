package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long orderId;
    private Boolean isPayed;

    public OrderCancelled(OrderData aggregate){
        super(aggregate);
    }
    public OrderCancelled(){
        super();
    }
}
