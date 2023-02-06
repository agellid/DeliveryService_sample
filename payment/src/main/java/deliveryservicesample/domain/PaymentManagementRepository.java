package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="paymentManagements", path="paymentManagements")
public interface PaymentManagementRepository extends PagingAndSortingRepository<PaymentManagement, Long>{

}
