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
    public boolean requestEmail(String email)  {
       

        // Add recipient
        String to = email + "@smit.smu.edu.in";

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
            message.setSubject("Hi JAXenter");

            // Put the content of your message
            message.setText("Hi there,we are just experimenting with JavaMail here");

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
