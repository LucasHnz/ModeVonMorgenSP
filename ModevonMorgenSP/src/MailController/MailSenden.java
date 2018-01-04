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
import javax.mail.Message.RecipientType;
/**
 * 
 * @author Falk Maoro
 *
 */
public class MailSenden {

	/**
	 * Sendet eine Mail von der Shop-Adresse: modevonmorgen@gmx.de
	 * @param empf�ngerAdresse Die Email des Empf�ngers.
	 * @param betreff Der Betreff der Email.
	 * @param text Der Text der Email.
	 */
	public static void sendMail(String empf�ngerAdresse, String betreff,
			String text) {
			
		Authenticator auth = getAuthenticator();
		Properties properties = getProperties();

		// Hier wird mit den Properties und dem Authenticator eine Session erzeugt
		Session session = Session.getDefaultInstance(properties, auth);

		// Message senden
		sendMessage(session, empf�ngerAdresse, betreff, text);
	}
	
	public static void sendMessage(Session session,
			String recipientsAddress, String subject, String text) {
		try {
			// Eine neue Message erzeugen
			Message msg = new MimeMessage(session);

			// Hier werden die Absender- und Empf�ngeradressen gesetzt
			msg.setFrom(new InternetAddress("modevonmorgen@gmx.de", "Mode Von Morgen"));

			// msg.addRecipient(Message.RecipientType.TO, new
			// InternetAddress(recipientsAddress));
			msg.setRecipient(RecipientType.TO, new InternetAddress(
					recipientsAddress));

			// Der Betreff wird gesetzt
			msg.setSubject(subject);

			// multipart message erstellen, in dem Text und Attachment gepuffert
			// werden
			Multipart multipart = new MimeMultipart();

			// Der Text wird gesetzt
			multipart.addBodyPart(getText(text));

			
			// Text zur Nachricht hinzuf�gen
			msg.setContent(multipart);

			// Senden der Nachricht
			Transport.send(msg);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Nachrichtentext wird gesetzt
	 * @return
	 */
	public static BodyPart getText(String text) {
		try {
			// message part erstellen
			BodyPart messageBodyPart = new MimeBodyPart();

			// Mailtext hinzuf�gen
			messageBodyPart.setText(text);

			// Daten zur�ckgeben
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
		// Den Properties wird die ServerAdresse hinzugef�gt
		properties.put("mail.smtp.host", "mail.gmx.net");
		// !!Wichtig!! Falls der SMTP-Server eine Authentifizierung verlangt
		// muss an dieser Stelle die Property auf "true" gesetzt
		// werden
		properties.put("mail.smtp.auth", "true");
		// Port setzen
		properties.put("mail.smtp.port", "587");
		// Protokoll festlegen
		properties.put("mail.transport.protocol", "smtp");
		// Verschl�sselung festlegen
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
				/**
				 * Diese Methode gibt ein neues PasswortAuthentication Objekt
				 * zurueck.
				 * 
				 * @see javax.mail.Authenticator#getPasswordAuthentication()
				 */
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("modevonmorgen@gmx.de", "passwort");
				}
			};
			return auth;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
