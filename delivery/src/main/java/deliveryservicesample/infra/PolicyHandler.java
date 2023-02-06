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
    @Autowired DeliveryRepository deliveryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryRequested'")
    public void wheneverDeliveryRequested_DeliveryRequest(@Payload DeliveryRequested deliveryRequested){

        DeliveryRequested event = deliveryRequested;
        System.out.println("\n\n##### listener DeliveryRequest : " + deliveryRequested + "\n\n");


        

        // Sample Logic //
        Delivery.deliveryRequest(event);
        

        

    }

}


