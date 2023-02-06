package deliveryservicesample.domain;

import deliveryservicesample.domain.KakaoTalkMessageRequest;
import deliveryservicesample.SmsApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="SmsMessage_table")
@Data

public class SmsMessage  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long smsMessageId;
    
    
    
    
    
    private String phoneNumber;
    
    
    
    
    
    private String msg;
    
    
    
    
    
    private String orderId;

    @PrePersist
    public void onPrePersist(){


        KakaoTalkMessageRequest kakaoTalkMessageRequest = new KakaoTalkMessageRequest(this);
        kakaoTalkMessageRequest.publishAfterCommit();

    }

    public static SmsMessageRepository repository(){
        SmsMessageRepository smsMessageRepository = SmsApplication.applicationContext.getBean(SmsMessageRepository.class);
        return smsMessageRepository;
    }






}
