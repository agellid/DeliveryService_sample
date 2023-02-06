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
// @RequestMapping(value="/orderData")
@Transactional
public class OrderDataController {
    @Autowired
    OrderDataRepository orderDataRepository;




    @RequestMapping(value = "orderData/{id}/ordercancel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public OrderData orderCancel(@PathVariable(value = "id") Long id, @RequestBody OrderCancelCommand orderCancelCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /orderData/orderCancel  called #####");
            Optional<OrderData> optionalOrderData = orderDataRepository.findById(id);
            
            optionalOrderData.orElseThrow(()-> new Exception("No Entity Found"));
            OrderData orderData = optionalOrderData.get();
            orderData.orderCancel(orderCancelCommand);
            
            orderDataRepository.save(orderData);
            return orderData;
            
    }
    



}
