package in.ashokit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;
public boolean sendEmail(String subject, String body,String to) {
boolean	isSent=false;
MimeMessage mimeMeg = mailSender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(mimeMeg);
try {
	helper.setTo(to);
	helper.setSubject(subject);
	helper.setText(body,true);
	 isSent = true;
	 mailSender.send(mimeMeg);
} catch (MessagingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}



return isSent;
}
}
