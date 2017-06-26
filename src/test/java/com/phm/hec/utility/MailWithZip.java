package com.phm.hec.utility;

import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailWithZip {
	public static String myuserName = "mahesh.anand@healthec.com";
	public static String mypassword = "igi$1234";

	public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
			String toAddress, String subject, String message, String[] attachFiles)
			throws AddressException, MessagingException {
		// sets SMTP server properties
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");

		props.put("mail.user", userName);
		props.put("mail.password", password);

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myuserName, mypassword);
			}
		};
		Session session = Session.getInstance(props, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFiles != null && attachFiles.length > 0) {
			for (String filePath : attachFiles) {
				MimeBodyPart attachPart = new MimeBodyPart();

				try {
					attachPart.attachFile(filePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(attachPart);
			}
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}

	/**
	 * Test sending e-mail with attachments
	 */
	@Test
	public void mail() {
		// SMTP info
		String host = "smtp.gmail.com";
		String port = "25";
		String mailFrom = myuserName;
		String password = mypassword;

		// Setting date in mail

		DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
		// get current date time with Date()
		Date date = new Date();

		// message info
		String mailTo = "mahesh.anand@healthec.com";
		String subject = "Automation Test Result" + "__" + dateFormat.format(date);
		String message = "Hi, " + '\n' + "Body of the content." + '\n' + "Thanks and regards," + '\n' + " Mahesh Anton";

		// attachments
		String[] attachFiles = new String[1];
		attachFiles[0] = "E:\\Personal\\Interview Test Manager\\Automation\\Selenium\\reports\\test.zip";
		// attachFiles[1] = "e:/Test/Music.mp3";
		// attachFiles[2] = "e:/Test/Video.mp4";

		try {

			sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, message, attachFiles);
			System.out.println("Email sent.");
		} catch (Exception ex) {
			System.out.println("Could not send email.");
			ex.printStackTrace();
		}
	}

}
