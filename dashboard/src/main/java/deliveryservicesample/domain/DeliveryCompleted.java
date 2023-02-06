package deliveryservicesample.domain;

import deliveryservicesample.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long deliveryID;
    private Long orderId;
    private String customerName;
    private String deliveryAddress;
    private Boolean isPayed;
    private String deliveryStatus;
}
