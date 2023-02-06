package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long menuId;
    private Integer qty;
    private Long customerId;
    private String orderstatus;
    private String foodstatus;

    public CookStarted(Store aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
