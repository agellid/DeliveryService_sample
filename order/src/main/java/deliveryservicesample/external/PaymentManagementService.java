package deliveryservicesample.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "payment", url = "${api.url.payment}")
public interface PaymentManagementService {
    @RequestMapping(method= RequestMethod.POST, path="/paymentManagements")
    public void paymentRequest(@RequestBody PaymentManagement paymentManagement);
}
