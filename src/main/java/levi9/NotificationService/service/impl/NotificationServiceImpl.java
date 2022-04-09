package levi9.NotificationService.service.impl;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import levi9.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private AmazonSNSClient snsClient;

    @Autowired
    private MailSender mailSender;

    String TOPIC_ARN = "arn:aws:sns:eu-south-1:727653473746:emailing_internshipdb";

    @Override
    public String addSubscription(String email) {
            SubscribeRequest request = new SubscribeRequest(TOPIC_ARN,
                    "email",email);
            snsClient.subscribe(request);
            return "We have sent you verification request for AWS on email " + email + " ,please check it." +
                    "\n" +
                    "After that,we will announce you through email that you succesfully verified your email!";


    }

    @Override
    public String publishMessageToTopic(){
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,
                buildsnsEmailBody(),"Email registered!");

        snsClient.publish(publishRequest);
        return " Verification email for registration succesfully sent!" ;
    }

    private String buildsnsEmailBody() {
        return "Hi, \n" +
                "\n" +
                "We are happy you succesfully logged in with your verified email :)" + "\n" +
                "Hope you will enjoy!" +"\n" +
                "Rent A Car app team AMD ";
    }

    @Override
   public String sendsesMessage( String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("rentacarapplicationt@gmail.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("CAO");
        simpleMailMessage.setText("cao");

        mailSender.send(simpleMailMessage);

        return "Ses mail successfully sent!";
   }
}
