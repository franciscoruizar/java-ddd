package ar.franciscoruiz.retentions.mails.application;

import ar.franciscoruiz.retentions.mails.domain.EmailService;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserCreatedEmailSender {
    private final EmailService emailService;

    public UserCreatedEmailSender(EmailService emailService) {
        this.emailService = emailService;
    }

    public void send(String to, String username, String name, String lastname) {

        String message = String.format("Hi, %s %s\n", name, lastname) +
            "Welcome to Java DDD Template!\n" +
            String.format("You registered with the username %s\n", username) +
            "Enjoy!";

        emailService.sendMessage(to, "Welcome to Java DDD Template", message);
    }
}
