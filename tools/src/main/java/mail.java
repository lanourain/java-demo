import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class mail {
    public static void main(String[] args) throws Exception {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("host");

        MimeMessage me = mailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(me, true, "utf-8");
            message.setTo("ToMailAddress");
            message.setFrom("FromMailAddress");
            message.setSubject("Test!!!");
            message.setText("test!!!!!");
            mailSender.send(me);
        } catch (Exception e) {
            System.out.println("send main fail {}" + e);

        }
    }
}
