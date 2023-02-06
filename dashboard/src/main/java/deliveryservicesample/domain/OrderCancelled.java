package deliveryservicesample.domain;

import deliveryservicesample.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCancelled extends AbstractEvent {

    private Long orderID;
    private Boolean isPayed;
}
