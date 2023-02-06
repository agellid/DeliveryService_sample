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
    @Autowired OrderDataRepository orderDataRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PaymentApproved'")
    public void wheneverPaymentApproved_IsPayed(@Payload PaymentApproved paymentApproved){

        PaymentApproved event = paymentApproved;
        System.out.println("\n\n##### listener IsPayed : " + paymentApproved + "\n\n");


        // Comments // 
		//결재완료 상태로 업데이트

        // Sample Logic //
        OrderData.isPayed(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_OrderReject(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener OrderReject : " + orderRejected + "\n\n");


        // Comments // 
		//주문이 상점주인에게 거부됨

        // Sample Logic //
        OrderData.orderReject(event);
        

        

    }

}


