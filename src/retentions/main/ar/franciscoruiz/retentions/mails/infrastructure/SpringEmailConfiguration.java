package ar.franciscoruiz.retentions.mails.infrastructure;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Service
public final class SpringEmailConfiguration {
    private final Parameter parameter;

    public SpringEmailConfiguration(Parameter parameter) {
        this.parameter = parameter;
    }

    @Bean
    public JavaMailSender javaMailSender() throws ParameterNotExist {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(parameter.get("MAIL_SENDER_HOST"));
        mailSender.setPort(parameter.getInt("MAIL_SENDER_PORT"));

        mailSender.setUsername(parameter.get("MAIL_SENDER_EMAIL"));
        mailSender.setPassword(parameter.get("MAIL_SENDER_PASSWORD"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
