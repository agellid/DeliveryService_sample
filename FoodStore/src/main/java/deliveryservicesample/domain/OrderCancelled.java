package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCancelled extends AbstractEvent {

    private Long orderId;
    private Boolean isPayed;
}


