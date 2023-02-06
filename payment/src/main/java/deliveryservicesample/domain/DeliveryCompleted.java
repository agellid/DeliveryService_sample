package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String customerName;
    private String deliveryAddress;
    private Boolean isPayed;
    private String deliveryStatus;
}


