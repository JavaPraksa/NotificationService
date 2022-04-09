package levi9.NotificationService.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface NotificationService {
    String addSubscription( String email);

    String publishMessageToTopic();

    String sendsesMessage( String email);
}
