package ar.franciscoruiz.retentions.mails.infrastructure;

import ar.franciscoruiz.retentions.mails.domain.EmailService;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;
import java.util.Objects;

@Service
public final class SpringEmailService implements EmailService {
    private final String            noReplyAddress;
    private final JavaMailSender    emailSender;
    private final SimpleMailMessage template;

    public SpringEmailService(Parameter parameter, JavaMailSender emailSender, SimpleMailMessage template) throws ParameterNotExist {
        this.noReplyAddress = parameter.get("NO_REPLY_ADDRESS");
        this.emailSender    = emailSender;
        this.template       = template;
    }

    @Override
    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(noReplyAddress);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailSender.send(message);
    }

    @Override
    public void sendMessageUsingTemplate(String to, String subject, String... templateModel) {
        String text = String.format(Objects.requireNonNull(template.getText()), templateModel.toString());
        sendMessage(to, subject, text);
    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String attachmentName, String pathToAttachment) {
        try {
            MimeMessage       message = emailSender.createMimeMessage();
            MimeMessageHelper helper  = new MimeMessageHelper(message, true);

            helper.setFrom(noReplyAddress);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment(attachmentName, file);

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessageUsingTemplate(String to, String subject, Map<String, Object> templateModel) {
        //TO-DO
    }
}
