package xyz.jangle.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮件发送工具类
 * @author jangle E-mail: jangle@jangle.xyz
 * @version 2019年12月10日 下午3:08:08 类说明
 */
public class EmailHelper {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("email-jangle");
	private static final String sendFrom = bundle.getString("email.from");
	private static final String username = bundle.getString("username");
	private static final String password = bundle.getString("password");
	private static final String host = bundle.getString("email.host");

	public static void sendEmail(String toEmail, String subject, String content) {
		Properties props = new Properties();
		props.setProperty("mail.host", host);
		props.setProperty("mail.smtp.auth", "true");
		MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		Authenticator authenticator = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getDefaultInstance(props, authenticator);
//		session.setDebug(true);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(sendFrom));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail));
			// message.setRecipients(RecipientType.TO,InternetAddress.parse("测试的接收的邮件多个以逗号隔开"));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String password = "abcdefg3";
		String content = "<h1>来自“阿景的当铺”的邮件,请接收你的密码：</h1><h3>你的密码是：" + password + "，请妥善保管好你的密码！</h3>";
		EmailHelper.sendEmail("274676957@qq.com", "来自“阿景的当铺”的邮件", content);
		System.out.println("完成发送");
	}

}
