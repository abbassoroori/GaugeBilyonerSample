package Utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 * Created by mert.yaman on 27/01/2017.
 * Bu classta;
 * zipper ile olusturulan test_results.zip dosyasi,
 * attachment olarak mail icerisine eklenir ve test sonuclarini inceleyecek kisilere
 * mail yolu ile gonderilir.
 */
public class sendMail {

    propertyReader prop = new propertyReader();
    public void sendEmail() {
//        System.getProperties().put("proxySet","true");
//        System.getProperties().put("socksProxyPort","8080");
//        System.getProperties().put("socksProxyHost","192.168.12.51");
//        Properties props = System.getProperties();
        boolean debug = true;
        Properties props = new Properties();
//      props.put("mail.smtp.host", "EXCCAS01.libero.int");
//      props.put("mail.smtp.host", "YBCAS01.libero.int");
//        props.put("mail.smtp.host", "ybdag02.libero.int");
        props.put("mail.smtp.host", "172.16.10.213");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", debug);
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.starttls.enable", debug);
        props.put("mail.transport.protocol", "smtp");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("mert.yaman@bilyoner.com", prop.getPassword());
                    }
                }
        );
        session.setDebug(debug);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mert.yaman@bilyoner.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("qa@bilyoner.com"));
            message.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse("monitoring@bilyoner.com"));
//            		InternetAddress.parse("mert.yaman@bilyoner.com"));

            message.setSubject("Test Results");

            String filename;
//            String filename2;

////           bilyoner mail server zip'i engelliyor bu nedenle sıkıstırmadan html dosyası gonderiliyor.
////           filename = System.getProperty("user.home") + "/Documents/SeleniumTests/" + runId + ".zip";

            filename = System.getProperty("user.dir") +"/test_results.zip";
//            filename2 = getLogFilePath();

            List<String> attachment_PathList=new ArrayList<String>();
            attachment_PathList.add(filename);  //// html report file
//            attachment_PathList.add(filename2); //// log file

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Selenium Gauge test sonuclari zip olarak ektedir. Zipi actiktan sonra index.html dosyasina cift tiklayin.");

            Multipart multipart = new MimeMultipart("mixed");
            multipart.addBodyPart(textPart);

            for (String path : attachment_PathList) {
                MimeBodyPart messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(path);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(source.getName());
                multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);
            Transport.send(message);
        }
        catch (MessagingException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
