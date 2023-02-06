package deliveryservicesample.domain;

import deliveryservicesample.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long orderID;
    private Long customerID;
    private Long menuID;
    private Integer qty;
    private String orderStatus;
    private String deliveryAddress;
    private String deliveryType;
    private String customerPhone;
    private Double amountOfPayment;
    private Boolean isPayed;
}
