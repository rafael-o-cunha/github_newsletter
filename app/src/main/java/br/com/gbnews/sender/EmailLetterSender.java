package br.com.gbnews.sender;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailLetterSender implements LetterSender {

    private final String username;
    private final String password;
    private final String smtpHost;
    private final int smtpPort;

    public EmailLetterSender(String username, String password, String smtpHost, int smtpPort) {
        this.username = username;
        this.password = password;
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
    }

    @Override
    public void send(String recipient, String subject, String message) {

        Properties properties = new Properties();

        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", String.valueOf(smtpPort));
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
            new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(
                            username,
                            password
                    );
                }
            }
        );

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(username));
            email.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            email.setSubject(subject);
            email.setText(message);
            Transport.send(email);
            System.out.println("Email enviado para: " + recipient);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email",e);
        }
    }
}