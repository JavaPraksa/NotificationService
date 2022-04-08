package levi9.NotificationService.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="notification-service")
public interface NotificationServiceApi {

    @GetMapping("/notification/verificationRequest/{email}")
    String addSubscription(@PathVariable String email);

}
