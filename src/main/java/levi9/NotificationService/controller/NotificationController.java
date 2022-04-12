package levi9.NotificationService.controller;

import levi9.NotificationService.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/notification",produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping("/sesEmailRegistration/{email}")
    public String sendsesMessageRegistration(@PathVariable String email){
            String answer;
            return answer = this.notificationService.sendsesMessageRegistration(email);
    }


    @GetMapping("/sesEmailRenting/email/{email}/rent/{id}/model/{model}")
    public String sendsesMessageRenting(@PathVariable String email, @PathVariable Long id,
                                        @PathVariable String model) {
        String answer;
        return answer = this.notificationService.sendsesMessageRenting(email,id,model);
    }






}
