package live.rishabh.project.aws.vsem.itDeptMagazine;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
    public boolean requestEmail(String email, String otp)  {
       

        // Add recipient
        String to = email + "@smit.smu.edu.in";
        String otpval = otp;
        // Add sender
        String from = System.getenv("EMAIL_ID");
        final String username = System.getenv("EMAIL_ID");// your Gmail username
        final String password = System.getenv("PASSWORD");// your Gmail password

        String host = "smtp-relay.sendinblue.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject
            message.setSubject("Auth : SMIT IT Dept Login");

            // Put the content of your message
            message.setText("Hi "+ email + ",we recived an request for email authorization. \n Ignore if not requested. Your OTP is : " + otpval);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");
            return true;

        } catch (MessagingException e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
