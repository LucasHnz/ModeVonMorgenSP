package MailController;

import java.util.Properties;

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
import javax.swing.JOptionPane;
import javax.mail.Message.RecipientType;
/**
 * 
 * @author Falk Maoro
 *
 */
public class MailSenden {

	/**
	 * Sendet eine Mail von der Shop-Adresse: modevonmorgen@gmx.de
	 * @param empfängerAdresse Die Email des Empfängers.
	 * @param betreff Der Betreff der Email.
	 * @param text Der Text der Email.
	 */
	public static void sendMail(String empfängerAdresse, String betreff,
			String text) {
			
		Authenticator auth = getAuthenticator();
		Properties properties = getProperties();

		Session session = Session.getDefaultInstance(properties, auth);

		sendMessage(session, empfängerAdresse, betreff, text);
	}
	
	public static void sendMessage(Session session,
			String recipientsAddress, String subject, String text) {
		try {
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress("modevonmorgen@gmx.de", "Mode Von Morgen"));

			msg.setRecipient(RecipientType.TO, new InternetAddress(
					recipientsAddress));

			msg.setSubject(subject);

			Multipart multipart = new MimeMultipart();

			multipart.addBodyPart(getText(text));

			msg.setContent(multipart);

			Transport.send(msg);

		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
				    "Email konnte nicht verschickt werden! \n" + e.getMessage(),
				    "Fehler",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Nachrichtentext wird gesetzt
	 * @return
	 */
	public static BodyPart getText(String text) {
		try {
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(text);

			return messageBodyPart;
		} catch (MessagingException me) {
			me.printStackTrace();
			return null;
		}

	}
	
	/**
	 * Eigenschaften des Mail-Servers werden gesetzt
	 * @return
	 */
	public static Properties getProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "mail.gmx.net");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.starttls.enable", "true");
		return properties;
	}

	/**
	 * Die Methode erzeugt ein MailAuthenticator Objekt aus den beiden
	 * Parametern user und passwort des Mailaccounts.
	 * 
	 * @param user
	 * @param password
	 */
	public static Authenticator getAuthenticator() {
		try {
			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("modevonmorgen@gmx.de", "SoftwareprojektWiSe1718");
				}
			};
			return auth;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
