package deliveryservicesample.domain;

import deliveryservicesample.domain.OrderTransferred;
import deliveryservicesample.FoodStoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Store_table")
@Data

public class Store  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long storeId;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Long menuId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String orderstatus;
    
    
    
    
    
    private String foodstatus;
    
    
    
    
    
    private String reason;
    
    
    
    
    
    private String deliverystatus;
    
    
    
    
    
    private Boolean isPayed;

    @PostPersist
    public void onPostPersist(){


        OrderTransferred orderTransferred = new OrderTransferred(this);
        orderTransferred.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static StoreRepository repository(){
        StoreRepository storeRepository = FoodStoreApplication.applicationContext.getBean(StoreRepository.class);
        return storeRepository;
    }



    public void orderReject(){
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

    }
    public void cookBegin(){
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

    }
    public void cookEnd(){
        CookFinishied cookFinishied = new CookFinishied(this);
        cookFinishied.publishAfterCommit();

    }
    public void deliveryRequest(){
        DeliveryRequested deliveryRequested = new DeliveryRequested(this);
        deliveryRequested.publishAfterCommit();

    }
    public void orderAccept(){
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

    }

    public static void orderTransfer(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        OrderTransferred orderTransferred = new OrderTransferred(store);
        orderTransferred.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            OrderTransferred orderTransferred = new OrderTransferred(store);
            orderTransferred.publishAfterCommit();

         });
        */

        
    }
    public static void orderCancel(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

        
    }


}
