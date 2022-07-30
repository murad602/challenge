package backend.challenge;

import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JavaMailSend {
//    @Autowired
//    private JavaMailSender javaMailSender;
    public void mailSend(String toEmail,
                         String subject,
                         String body){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("mabdullayev770@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);

//        javaMailSender.send(mailMessage);

        System.out.println("mesaj getdi------------");

    }
}
