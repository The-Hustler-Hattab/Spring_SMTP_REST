package com.mtattab.emailservice.service;

import java.util.Properties;

import com.mtattab.emailservice.model.ResponseRestModel;
import com.mtattab.emailservice.repository.EmailRepository;
import com.mtattab.emailservice.util.AESEncryption;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;




@Data
@Service
@Scope("prototype")
@Slf4j
public class SMTP implements DisposableBean {


    @Autowired
    AESEncryption aesEncryption;
    @Autowired
    EmailRepository emailRepository;
    Properties props;
    String fromEmail;
    String password;
    Session session;

    public SMTP(){
        this.props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
    }

    // helper method to create connection
    private void connectToSMTP(){
        this.session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
    }

    public ResponseRestModel sendEmail(String toEmail, String subject, String messageText, boolean isHtmlEnabled) {
        if (!checkUserInput())return new ResponseRestModel(HttpStatus.BAD_REQUEST.value(),"Invalid from email");
        connectToSMTP();
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);

            if (isHtmlEnabled){
                message.setContent(messageText, "text/html");
            }else message.setText(messageText);

            Transport.send(message);
            return new ResponseRestModel(HttpStatus.OK.value(), "Email sent successfully. Please check the spam folder.");
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseRestModel(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Email send failed due to: "+e.getMessage());
        }
    }


    private boolean checkUserInput() {
        String password = emailRepository.getPasswordForEmail(this.fromEmail);
        if (password == null)return false;
        else{

            try {
                this.password = aesEncryption.decrypt(password);
            } catch (Exception e) {
                log.error("[-] Error occurred while decrypting password: {}",e.getMessage());
                return false;
            }

            return true;
        }

    }

    public ResponseRestModel getAllEmails() {
        return new ResponseRestModel(HttpStatus.OK.value(),"Here is the list of available emails", emailRepository.getAllEmailsFromTable());
    }

    @Override
    public void destroy()  {
        // clean resources
        try {
            if (this.session!=null && this.session.getTransport().isConnected()) this.session.getTransport().close();

        } catch (MessagingException e) {
            log.error("[-] error occurred while closing resources {}", e.getMessage());
            e.printStackTrace();
        }
    }
}

