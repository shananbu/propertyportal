package com.ats.property.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * The MailAuthenticator.
 *
 * @author anbarasan.s
 */

public class MailAuthenticator extends Authenticator {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(IMailService.FROM_MAIL_ID, IMailService.FROM_MAIL_PASSWORD);
    }
}