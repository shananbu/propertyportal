package com.ats.property.mail;


import org.springframework.util.MimeTypeUtils;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.event.TransportAdapter;
import javax.mail.event.TransportEvent;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * The MailService.
 *
 * @author anbarasan.s
 */
public class MailService implements IMailService {


    @Override
    public boolean sendMail(final MailBean data) {
        Transport transport = null;
        try {
            Session session = getSession();
            MimeMessage mimeMessage = getMimeMessage(session, data);
            MimeBodyPart mimeBodyPart = getMimeBodyPart(data);
            Multipart mimeMultipart = getMultipart(mimeBodyPart);
            mimeMessage.setContent(mimeMultipart);

            transport = session.getTransport(SMPTP);
            transport.addTransportListener(
                    new TransportAdapter() {
                        public void messageDelivered(TransportEvent te) {
                            data.setMailStatus(true);
                            System.out.println("Successfully Delivered");
                        }

                        public void messageNotDelivered(TransportEvent te) {
                            data.setMailStatus(false);
                            System.out.println("Delivered Failed");
                        }
                    }
            );
            transport.connect(MAIL_SERVER, FROM_MAIL_ID, FROM_MAIL_PASSWORD);
            mimeMessage.saveChanges();
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

        } catch (Exception ex) {
            ex.printStackTrace();
            data.setMailStatus(false);
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private Session getSession() {
        Properties props = System.getProperties();
        props.put(PROP_MAIL_SERVER, MAIL_SERVER);
        props.put(PROP_MAIL_AUTH, PROP_MAIL_AUTH_VALUE);
        return Session.getDefaultInstance(props, new MailAuthenticator());
    }

    private MimeMessage getMimeMessage(Session session, final MailBean data) throws MessagingException {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM_MAIL_ID));
        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(data.getToMailId()));
        msg.setSubject(data.getSubject());
        msg.setSentDate(new Date());
        return msg;
    }

    private MimeBodyPart getMimeBodyPart(final MailBean data) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(data.getMailBody(), MimeTypeUtils.TEXT_HTML.toString());
        return mimeBodyPart;
    }

    private Multipart getMultipart(MimeBodyPart mimeBodyPart) throws MessagingException {
        Multipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        return mimeMultipart;
    }
}
