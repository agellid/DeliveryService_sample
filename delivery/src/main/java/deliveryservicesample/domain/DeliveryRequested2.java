package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryRequested2 extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String customerName;
    private String deliveryAddress;
    private Boolean isPayed;
    private String deliveryStatus;

    public DeliveryRequested2(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryRequested2(){
        super();
    }
}
