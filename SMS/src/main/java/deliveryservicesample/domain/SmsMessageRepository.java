package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="smsMessages", path="smsMessages")
public interface SmsMessageRepository extends PagingAndSortingRepository<SmsMessage, Long>{

}
