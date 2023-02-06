package deliveryservicesample.external;

import lombok.Data;
import java.util.Date;
@Data
public class PaymentManagement {

    private Long paymentId;
    private String orderId;
    private Integer payStatus;
    private Double price;
}


