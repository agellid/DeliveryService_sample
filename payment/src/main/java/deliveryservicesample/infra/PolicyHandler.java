package deliveryservicesample.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import deliveryservicesample.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import deliveryservicesample.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired PaymentManagementRepository paymentManagementRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCancelled'")
    public void wheneverOrderCancelled_PaymentCancellationRequest(@Payload OrderCancelled orderCancelled){

        OrderCancelled event = orderCancelled;
        System.out.println("\n\n##### listener PaymentCancellationRequest : " + orderCancelled + "\n\n");


        

        // Sample Logic //
        PaymentManagement.paymentCancellationRequest(event);
        

        

    }

    @Autowired
    deliveryservicesample.external.OrderDataService orderDataService;

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompleted'")
    public void wheneverDeliveryCompleted_Processpayment(@Payload DeliveryCompleted deliveryCompleted){

        DeliveryCompleted event = deliveryCompleted;
        System.out.println("\n\n##### listener Processpayment : " + deliveryCompleted + "\n\n");

        // REST Request Sample
        
        // orderDataService.getOrderData(/** mapping value needed */);


        

        // Sample Logic //
        PaymentManagement.processpayment(event);
        

        

    }

}


