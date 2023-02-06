package deliveryservicesample.domain;

import deliveryservicesample.domain.DeliveryRequested2;
import deliveryservicesample.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    
    
    
    
    private Long deliveryId;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String customerName;
    
    
    
    
    
    private String deliveryAddress;
    
    
    
    
    
    private Boolean isPayed;
    
    
    
    
    
    private String deliveryStatus;

    @PostPersist
    public void onPostPersist(){


        DeliveryRequested2 deliveryRequested2 = new DeliveryRequested2(this);
        deliveryRequested2.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }



    public void completeDelivery(){
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

    }
    public void startDelivery(){
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();

    }

    public static void deliveryRequest(DeliveryRequested deliveryRequested){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryRequested2 deliveryRequested2 = new DeliveryRequested2(delivery);
        deliveryRequested2.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryRequested.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryRequested2 deliveryRequested2 = new DeliveryRequested2(delivery);
            deliveryRequested2.publishAfterCommit();

         });
        */

        
    }


}
