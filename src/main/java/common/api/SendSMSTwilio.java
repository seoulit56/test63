package common.api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMSTwilio {
	
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC338980fc50c34e2e011260ab6efb6bca";
    public static final String AUTH_TOKEN = "9c71cb5f9be0cc282a12ea152ae17480";
    
    // SMS 전송
    public static int sendSMS (String phoneNum) {
  
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
      // 휴대폰 인증번호 생성
      int authNum = randomRange(100000, 999999);
      
      
      // 전송대상 휴대폰 번호
      String sendTarget = "+82" + phoneNum;
      
      // 전송 메세지
      String authMsg = "SI Potal 인증번호 [" + authNum + "]" ;
      
      
      Message message = Message.creator(
          // to
          new PhoneNumber(sendTarget),
          // from
          new PhoneNumber("+12058988670"), 
          // message
          authMsg).create();
      
      return authNum;
      
    }
      
    // 인증번호 범위 지정
    public static int randomRange(int n1, int n2) {
      return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }
    
    
  }