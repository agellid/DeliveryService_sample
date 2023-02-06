package deliveryservicesample.infra;
import deliveryservicesample.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;



    @RequestMapping(value = "deliveries/{id}/completedelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery completeDelivery(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/completeDelivery  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.completeDelivery();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



    @RequestMapping(value = "deliveries/{id}/startdelivery",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Delivery startDelivery(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /delivery/startDelivery  called #####");
            Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);
            
            optionalDelivery.orElseThrow(()-> new Exception("No Entity Found"));
            Delivery delivery = optionalDelivery.get();
            delivery.startDelivery();
            
            deliveryRepository.save(delivery);
            return delivery;
            
    }
    



}
