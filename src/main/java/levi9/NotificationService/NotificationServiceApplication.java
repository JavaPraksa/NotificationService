package levi9.NotificationService;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import levi9.NotificationService.api.NotificationServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableFeignClients(clients= NotificationServiceApi.class)
@SpringBootApplication(
		exclude = {
				org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
				org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class,
				//DataSourceAutoConfiguration.class
		}
)

@RestController
public class NotificationServiceApplication {

	@Autowired
	private AmazonSNSClient snsClient;

	String TOPIC_ARN = "arn:aws:sns:eu-south-1:727653473746:emailing_internshipdb";


	// ovde cu prosledjivati mejl adresu na koju treba da posaljem verifikaciju
	@GetMapping("/verificationRequest/{email}")
	public String addSubscription(@PathVariable String email){
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN,
				"email",email);
		snsClient.subscribe(request);
		return "We have sent you verification request for AWS on email " + email + " ,please check it." +
				"\n" +
				"After that,we will announce you through email that you succesfully verified your email!";

	}

	@GetMapping("/sendEmail")
	public String publishMessageToTopic() {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,
				buildEmailBody(),"Email registered!");

		snsClient.publish(publishRequest);
		return " Verification email for registration succesfully sent!" ;

	}

	private String buildEmailBody() {
		return "Hi, \n" +
				"\n" +
				"Thank you for registering to our Rent A Car app! \n" +
				"\n" +
				"Rent A Car app team AMD ";
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
