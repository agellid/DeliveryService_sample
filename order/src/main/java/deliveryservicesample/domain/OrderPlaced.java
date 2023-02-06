package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long orderId;
    private Long customerId;
    private Long menuId;
    private Integer qty;
    private String orderStatus;
    private String deliveryAddress;
    private String deliveryType;
    private String customerPhone;
    private Double amountOfPayment;
    private Boolean isPayed;

    public OrderPlaced(OrderData aggregate){
        super(aggregate);
    }
    public OrderPlaced(){
        super();
    }
}
