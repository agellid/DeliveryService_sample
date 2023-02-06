package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long menuId;
    private Long customerId;
    private String orderstatus;
    private String reason;
}


