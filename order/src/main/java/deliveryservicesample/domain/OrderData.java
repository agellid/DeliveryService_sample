package deliveryservicesample.domain;

import deliveryservicesample.domain.OrderPlaced;
import deliveryservicesample.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderData_table")
@Data

public class OrderData  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
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

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        deliveryservicesample.external.PaymentManagement paymentManagement = new deliveryservicesample.external.PaymentManagement();
        // mappings goes here
        OrderApplication.applicationContext.getBean(deliveryservicesample.external.PaymentManagementService.class)
            .paymentRequest(paymentManagement);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }

    public static OrderDataRepository repository(){
        OrderDataRepository orderDataRepository = OrderApplication.applicationContext.getBean(OrderDataRepository.class);
        return orderDataRepository;
    }



    public void orderCancel(OrderCancelCommand orderCancelCommand){
        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

    }

    public static void isPayed(PaymentApproved paymentApproved){

        /** Example 1:  new item 
        OrderData orderData = new OrderData();
        repository().save(orderData);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentApproved.get???()).ifPresent(orderData->{
            
            orderData // do something
            repository().save(orderData);


         });
        */

        
    }
    public static void orderReject(OrderRejected orderRejected){

        /** Example 1:  new item 
        OrderData orderData = new OrderData();
        repository().save(orderData);

        OrderCancelled orderCancelled = new OrderCancelled(orderData);
        orderCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(orderData->{
            
            orderData // do something
            repository().save(orderData);

            OrderCancelled orderCancelled = new OrderCancelled(orderData);
            orderCancelled.publishAfterCommit();

         });
        */

        
    }


}
