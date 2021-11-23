import java.util.Properties
import javax.mail.internet.{InternetAddress, MimeBodyPart, MimeMessage, MimeMultipart}
import javax.mail.{Authenticator, Message, PasswordAuthentication, Session, Transport}

object Main2 extends App {
  val username = "aakash221098@gmail.com"
  val password = "Rithanya12345"

  val prop = new Properties()
  prop.put("mail.smtp.host", "smtp.gmail.com")
  prop.put("mail.smtp.port", "587")
  prop.put("mail.smtp.auth", "true")
  prop.put("mail.smtp.starttls.enable", "true") //TLS

  val session = Session.getInstance(prop,
    new Authenticator(){
      override def getPasswordAuthentication: PasswordAuthentication = new PasswordAuthentication(username,password)
    })

  val message = new MimeMessage(session);
  message.setFrom(new InternetAddress("aakash221098@gmail.com"));
  message.addRecipient(Message.RecipientType.TO,new InternetAddress("aakashakshay98@gmail.com"))
  message.setSubject("Mail Subject");

  val  msg = "This is my first email using JavaMailer";

  val mimeBodyPart = new MimeBodyPart();
  mimeBodyPart.setContent(msg, "text/html");

 val multipart = new MimeMultipart();
  multipart.addBodyPart(mimeBodyPart);

  message.setContent(multipart);

  Transport.send(message);
}
