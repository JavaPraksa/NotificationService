package levi9.NotificationService.controller;

import levi9.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/notification")
public class NotificationController {


    @Autowired
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    // ovde cu prosledjivati mejl adresu na koju treba da posaljem verifikaciju
    @GetMapping("/snsverificationRequest/{email}")
    public String addSubscription(@PathVariable String email){
        String answer;
        return answer = this.notificationService.addSubscription(email);

    }

    @GetMapping("/snsverifiedEmailLogging")
    public String publishMessageToTopic() {
        String answer;
        return answer = this.notificationService.publishMessageToTopic();
    }

    @GetMapping("/sesEmail/{email}")
    public String sendsesMessage(@PathVariable String email){
            String answer;
            return answer = this.notificationService.sendsesMessage(email);
    }




}
