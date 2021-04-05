package ar.franciscoruiz.retentions.mails.domain;

import java.util.Map;

public interface EmailService {
    void sendMessage(String to, String subject, String text);

    void sendMessageUsingTemplate(String to, String subject, String... templateModel);

    void sendMessageWithAttachment(String to, String subject, String text, String attachmentName, String pathToAttachment);

    void sendMessageUsingTemplate(String to, String subject, Map<String, Object> templateModel);
}
