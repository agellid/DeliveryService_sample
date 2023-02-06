package deliveryservicesample.external;

import lombok.Data;
import java.util.Date;
@Data
public class OrderData {

    private Long orderId;
    private Long customerId;
    private Long menuId;
    private Integer qty;
    private String orderStatus;
    private String deliveryAddress;
    private String deliveryType;
    private String customerPhone;
    private Boolean isPayed;
    private Double amountOfPayment;
}


