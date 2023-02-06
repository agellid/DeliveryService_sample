package deliveryservicesample.domain;

import deliveryservicesample.domain.*;
import deliveryservicesample.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class KakaoTalkMessageRequest extends AbstractEvent {

    private Long id;

    public KakaoTalkMessageRequest(SmsMessage aggregate){
        super(aggregate);
    }
    public KakaoTalkMessageRequest(){
        super();
    }
}
