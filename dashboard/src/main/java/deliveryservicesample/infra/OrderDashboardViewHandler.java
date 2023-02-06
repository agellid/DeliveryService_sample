package deliveryservicesample.infra;

import deliveryservicesample.domain.*;
import deliveryservicesample.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDashboardViewHandler {

    @Autowired
    private OrderDashboardRepository orderDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderDashboard orderDashboard = new OrderDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            orderDashboard.setOrderStatus(orderPlaced.getOrderStatus());
            orderDashboard.setDeliveryStatus("배송전");
            orderDashboard.setPrice(orderPlaced.getAmountOfPayment());
            orderDashboard.setOrderId(orderPlaced.getOrderId());
            // view 레파지 토리에 save
            orderDashboardRepository.save(orderDashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancelled_then_UPDATE_1(@Payload OrderCancelled orderCancelled) {
        try {
            if (!orderCancelled.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(orderCancelled.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setOrderStatus("주문취소");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_2(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(deliveryStarted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setOrderStatus("배송시작");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCompleted_then_UPDATE_3(@Payload DeliveryCompleted deliveryCompleted) {
        try {
            if (!deliveryCompleted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(deliveryCompleted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setOrderStatus("배송완료");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

