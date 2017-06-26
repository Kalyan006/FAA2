package com.phm.hec.utility;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class EmailUtil {

	public static Logger addlog = Logger.getLogger(EmailUtil.class.getName());
	public Properties props = null;
	public Session session = null;
	public Store store = null;
	public static Folder folder = null;
	public Message mailFromHealthEC = null;

	public String protocol = "imap";
	public String host = "imap.gmail.com";
	public String port = "993";

	Logger logger = addlog;

	public void openEmailAccountOf(final String email, final String password) {

		logger.info("open gmail account with mail id ----> " + email + " and password ---> " + password);
		// logger.info("Protocol : " + protocol + "|| Host : " + host + " ||
		// Port : " + port);
		props = getServerProperties(protocol, host, port);
		// logger.info("PROPS " + props);

		// session = Session.getDefaultInstance(props, new
		// GMailAuthenticator(email, password));
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		// session.setDebug(true);
		// logger.info("Session : " +session);
		try {
			logger.info("Store");
			Store store = session.getStore("imaps");
			logger.info("Store :" + store);
			// store = session.getStore("imaps");
			logger.info("Store Connect Email : " + email + " Password :" + password);
			store.connect("imap.gmail.com", email, password);
			folder = store.getFolder("inbox");
			folder.open(Folder.READ_WRITE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Properties getServerProperties(String protocol, String host, String port) {
		Properties properties = new Properties();

		// server setting
		properties.put(String.format("mail.%s.host", protocol), host);
		properties.put(String.format("mail.%s.port", protocol), port);

		// SSL setting
		properties.setProperty(String.format("mail.%s.socketFactory.class", protocol),
				"javax.net.ssl.SSLSocketFactory");
		properties.setProperty(String.format("mail.%s.socketFactory.fallback", protocol), "false");
		properties.setProperty(String.format("mail.%s.socketFactory.port", protocol), String.valueOf(port));

		properties.setProperty("mail.imap.host", "imap.gmail.com");
		properties.setProperty("mail.store.protocol", "imaps");
		properties.setProperty("http.proxySet", "true");
		properties.setProperty("http.proxyHost", host);
		properties.setProperty("http.proxyPort", port);
		properties.setProperty("mail.imap.port", "993");
		properties.setProperty("mail.store.protocol", "imaps");
		properties.setProperty("mail.imaps.connectiontimeout", "5000");
		properties.setProperty("mail.imaps.timeout", "5000");
		properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.imap.socketFactory.fallback", "false");

		return properties;
	}

	public boolean waitforMailToBeReceived(String subject) {
		int timeSliceMs = 1000;
		int timeoutMs = 30000;
		do {
			try {
				Thread.sleep(timeSliceMs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeoutMs -= timeSliceMs;
		} while (timeoutMs > 0 && !searchEmailBySubject(subject));
		if (timeoutMs > 0) {
			return true;
		}
		return false;
	}

	public boolean searchEmailBySubject(String subject) {
		int count;
		try {
			count = folder.getMessageCount();
			// logger.info("count::"+count);
			for (int i = 1; i <= count; i++) {
				if (folder.getMessage(i).getSubject().contains(subject)) {
					return true;
				}
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public String getEmailContent(String subject) {
		int count;
		String passCode = null;
		String[] partContenet = null;
		try {
			count = folder.getMessageCount();

			for (int i = 1; i <= count; i++) {
				if (folder.getMessage(i).getSubject().contains(subject)) {
					Object msgContent = folder.getMessage(i).getContent();
					String content = "";
					/* Check if content is pure text/html or in parts */
					if (msgContent instanceof Multipart) {
						Multipart multipart = (Multipart) msgContent;
						BodyPart bodyPart = multipart.getBodyPart(1);
						content += getText(bodyPart);
					} else {
						content = folder.getMessage(i).getContent().toString();
					}
					// logger.info("content::"+content);
					if (content != null) {
						partContenet = content.split("</span>");
					}
					if (partContenet != null) {
						passCode = partContenet[0].substring(partContenet[0].length() - 5, partContenet[0].length());
					}

					logger.info("passCode::" + passCode);
					// return passCode;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return passCode;
	}

	public void deleteEmail(String subject) throws Exception {
		int count = folder.getMessageCount();
		for (int i = 1; i <= count; i++) {
			if (folder.getMessage(i).getSubject().contains(subject)) {
				folder.getMessage(i).setFlag(Flags.Flag.DELETED, true);
				break;
			}
		}
	}

	public void deleteEntireInbox() throws Exception {
		int count = folder.getMessageCount();
		for (int i = 1; i <= count; i++) {
			folder.getMessage(i).setFlag(Flags.Flag.DELETED, true);
		}
	}

	public void closeInbox() throws Exception {
		folder.close(true);
		store.close();
	}

	private String getText(Part p) throws MessagingException, IOException {
		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			return s;
		}
		if (p.isMimeType("multipart/alternative")) {
			Multipart mp = (Multipart) p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getText(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						return s;
				} else {
					return getText(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		EmailUtil emailUtil = new EmailUtil();
		emailUtil.openEmailAccountOf("healthecuat@gmail.com", "igi$12345");
		emailUtil.getEmailContent("OTP");
	}
}

class GMailAuthenticator extends Authenticator {
	String user;
	String pw;

	public GMailAuthenticator(String username, String password) {
		super();
		this.user = username;
		this.pw = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		System.out.println(new PasswordAuthentication(user, pw));
		return new PasswordAuthentication(user, pw);
	}
}
