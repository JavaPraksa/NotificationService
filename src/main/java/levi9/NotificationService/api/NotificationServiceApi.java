package levi9.NotificationService.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="notification-service")
public interface NotificationServiceApi {


    @GetMapping("/notification/snsverificationRequest/{email}")
     String addSubscription(@PathVariable String email);

    @GetMapping("/notification/snsverifiedEmailLogging")
    String publishMessageToTopic();

    @GetMapping("/notification/sesEmailRegistration/{email}")
    String sendsesMessageRegistration(@PathVariable String email);

    @GetMapping("/notification/sesEmailRenting/email/{email}/rent/{id}/model/{model}")
    String sendsesMessageRenting(@PathVariable String email, @PathVariable Long id,
                                 @PathVariable String model);
}
