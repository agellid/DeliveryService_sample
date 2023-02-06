package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeliveryRequested extends AbstractEvent {

    private Long storeId;
    private Long menuId;
    private Integer qty;
    private Long customerId;
    private String address;
    private String orderstatus;
    private String foodstatus;
    private String deliverystatus;
    private Boolean isPayed;
}


