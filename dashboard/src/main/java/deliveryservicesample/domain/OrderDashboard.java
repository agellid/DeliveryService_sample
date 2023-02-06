package deliveryservicesample.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="OrderDashboard_table")
@Data
public class OrderDashboard {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long orderId;
        private String orderStatus;
        private String deliveryStatus;
        private Double price;
        private String payId;
        private String payStatus;


}
