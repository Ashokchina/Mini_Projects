package in.ashokit.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
@Component
public class EmailUtils {
	@Autowired
 private JavaMailSender mailSender;
 public boolean sendEmail(String Subject, String body , String to) {
	boolean isSent = false;
	try {
		MimeMessage mimeMsg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
		helper.setTo(to);
		helper.setSubject(Subject);
		helper.setText(body, true);
		 isSent = true;
		 mailSender.send(mimeMsg);
	}catch (Exception e) {
		e.printStackTrace();
	}
	 
	 
	 return isSent;
	 
 }
}
