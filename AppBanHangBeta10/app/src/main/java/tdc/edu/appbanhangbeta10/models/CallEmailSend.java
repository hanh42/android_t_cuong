package tdc.edu.appbanhangbeta10.models;

import android.util.Log;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CallEmailSend {
    private String username;
    private String password;
    private Properties props;

    public CallEmailSend(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }


    public void sendEmail(String recipient, String subject, String messageBody) throws MessagingException {
        Log.d("TAG", "sendEmail: 1");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Log.d("TAG", "sendEmail: 2");

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipient));
        message.setSubject(subject);
        Log.d("TAG", "sendEmail: 3");

        // Create a multipart message to handle attachments
        Multipart multipart = new MimeMultipart();
        Log.d("TAG", "sendEmail: 4");

        // Create a message body part for the text message
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messageBody);
        Log.d("TAG", "sendEmail: 5");

        // Add the message body part to the multipart message
        multipart.addBodyPart(messageBodyPart);
        Log.d("TAG", "sendEmail: 6");

        // Set the content of the message to the multipart message
        message.setContent(multipart);
        Log.d("TAG", "sendEmail: 7");

        // Send the message
        Transport.send(message);
        Log.d("TAG", "sendEmail: 8");
    }
}