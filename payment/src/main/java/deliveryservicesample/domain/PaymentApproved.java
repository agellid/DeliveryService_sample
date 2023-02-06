package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PaymentApproved extends AbstractEvent {

    private Long id;
    private Double price;
    private String productId;
    private Integer status;
    private Integer payStatus;
    private Long paymentId;
    private String orderId;

    public PaymentApproved(PaymentManagement aggregate){
        super(aggregate);
    }
    public PaymentApproved(){
        super();
    }
}
