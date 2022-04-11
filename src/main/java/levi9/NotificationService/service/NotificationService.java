package levi9.NotificationService.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface NotificationService {
    String addSubscription( String email);

    String publishMessageToTopic();

    String sendsesMessageRegistration( String email);

    String sendsesMessageRenting(String email,Long id,String model);

}
