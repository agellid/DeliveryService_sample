package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderTransferred extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long menuId;
    private Integer qty;
    private Long customerId;
    private String address;

    public OrderTransferred(Store aggregate){
        super(aggregate);
    }
    public OrderTransferred(){
        super();
    }
}
