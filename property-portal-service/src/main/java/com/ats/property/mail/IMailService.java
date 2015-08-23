package com.ats.property.mail;

/**
 * The IMailService.
 *
 * @author anbarasan.s
 */
public interface IMailService {
    String FROM_MAIL_ID = "info@1acreindia.com";
    String FROM_MAIL_PASSWORD = "1acreindiainfo@";
    String MAIL_SERVER = "mail.1acreindia.com";
    String SMPTP = "smtp";

    String PROP_MAIL_SERVER = "mail.smtp.host";
    String PROP_MAIL_AUTH = "mail.smtp.auth";
    String PROP_MAIL_AUTH_VALUE = "true";

    boolean sendMail(final MailBean data);
}
