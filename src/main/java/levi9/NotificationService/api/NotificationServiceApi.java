package levi9.NotificationService.api;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="notification-service")
public interface NotificationServiceApi {

}
