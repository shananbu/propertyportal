package com.ats.property.mail;

/**
 * The MailBean.
 *
 * @author anbarasan.s
 */
public class MailBean {
    private String toMailId;
    private String subject;
    private String mailBody;
    private boolean mailStatus;
    private String passwordRecoveryToken;

    public boolean isMailStatus() {
        return mailStatus;
    }

    public void setMailStatus(boolean mailStatus) {
        this.mailStatus = mailStatus;
    }

    public String getToMailId() {
        return toMailId;
    }

    public void setToMailId(String toMailId) {
        this.toMailId = toMailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public String getPasswordRecoveryToken() {
        return passwordRecoveryToken;
    }

    public void setPasswordRecoveryToken(String passwordRecoveryToken) {
        this.passwordRecoveryToken = passwordRecoveryToken;
    }

}
