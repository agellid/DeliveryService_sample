package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="orderData", path="orderData")
public interface OrderDataRepository extends PagingAndSortingRepository<OrderData, Long>{

}
