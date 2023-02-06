package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long menuId;
    private Long customerId;
    private String orderstatus;
    private String reason;

    public OrderRejected(Store aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}
