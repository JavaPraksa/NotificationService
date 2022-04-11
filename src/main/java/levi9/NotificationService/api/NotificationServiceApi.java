package levi9.NotificationService.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="notification-service")
public interface NotificationServiceApi {
    @GetMapping(value = "/notification/v1")
    String example1();

    @GetMapping("/notification/snsverificationRequest/{email}")
     String addSubscription(@PathVariable String email);

    @GetMapping("/notification/snsverifiedEmailLogging")
    String publishMessageToTopic();

    @GetMapping("/notification/sesEmailRegistration/{email}")
    String sendsesMessageRegistration(@PathVariable String email);

    @GetMapping("/notification/sesEmailRenting/{email}/{id}/{model}")
    String sendsesMessageRenting(@PathVariable String email, @PathVariable Long id,
                                 @PathVariable String model);
}
