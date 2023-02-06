package deliveryservicesample.domain;

import deliveryservicesample.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryStarted extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String customerName;
    private String deliveryAddress;
    private Boolean isPayed;
    private String deliveryStatus;
}
