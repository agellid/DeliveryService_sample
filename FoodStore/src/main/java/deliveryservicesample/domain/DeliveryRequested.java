package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


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

    public DeliveryRequested(Store aggregate){
        super(aggregate);
    }
    public DeliveryRequested(){
        super();
    }
}
