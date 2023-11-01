package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Toast;

import tdc.edu.appbanhangbeta10.R;
import tdc.edu.appbanhangbeta10.models.CallEmailSend;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
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

public class EmailSender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen_mail);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        CallEmailSend emailSender = new CallEmailSend("charliechu528@gmail.com", "nguyenthiphuongthanh");
//        try {
//            emailSender.sendEmail("dinhh7844@gmail.com", "HELLO", "xin chao!");
//            Toast.makeText(this, "gui duoc nha", Toast.LENGTH_SHORT).show();
//
//        } catch (MessagingException e) {
//            Toast.makeText(this, "khong gui duoc", Toast.LENGTH_SHORT).show();
//        }


        Properties props = new Properties();
        props.put("mail.smtp.host", "your.smtp.host");
        props.put("mail.smtp.port", "your.smtp.port");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("charliechu528@gmail.com", "nguyenthiphuongthanh");
            }
        });
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("charliechu528@gmail.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("phipk456@gmail.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            message.setSubject("hello");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            message.setText("hello");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}