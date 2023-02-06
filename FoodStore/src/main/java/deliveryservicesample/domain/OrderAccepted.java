package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long menuId;
    private Integer qty;
    private Long customerId;
    private String orderstatus;

    public OrderAccepted(Store aggregate){
        super(aggregate);
    }
    public OrderAccepted(){
        super();
    }
}
