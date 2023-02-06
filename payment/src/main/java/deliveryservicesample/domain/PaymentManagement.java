package deliveryservicesample.domain;

import deliveryservicesample.domain.PaymentApproved;
import deliveryservicesample.domain.PaymentApprovalCanceled;
import deliveryservicesample.PaymentApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="PaymentManagement_table")
@Data

public class PaymentManagement  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long paymentId;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private Integer payStatus;
    
    
    
    
    
    private Double price;

    @PostPersist
    public void onPostPersist(){
    }
    @PrePersist
    public void onPrePersist(){


        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();



        PaymentApprovalCanceled paymentApprovalCanceled = new PaymentApprovalCanceled(this);
        paymentApprovalCanceled.publishAfterCommit();

    }

    public static PaymentManagementRepository repository(){
        PaymentManagementRepository paymentManagementRepository = PaymentApplication.applicationContext.getBean(PaymentManagementRepository.class);
        return paymentManagementRepository;
    }




    public static void paymentCancellationRequest(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        PaymentManagement paymentManagement = new PaymentManagement();
        repository().save(paymentManagement);

        PaymentApprovalCanceled paymentApprovalCanceled = new PaymentApprovalCanceled(paymentManagement);
        paymentApprovalCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(paymentManagement->{
            
            paymentManagement // do something
            repository().save(paymentManagement);

            PaymentApprovalCanceled paymentApprovalCanceled = new PaymentApprovalCanceled(paymentManagement);
            paymentApprovalCanceled.publishAfterCommit();

         });
        */

        
    }
    public static void processpayment(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        PaymentManagement paymentManagement = new PaymentManagement();
        repository().save(paymentManagement);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(paymentManagement->{
            
            paymentManagement // do something
            repository().save(paymentManagement);


         });
        */

        
    }


}
