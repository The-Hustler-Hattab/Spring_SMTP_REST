package com.mtattab.emailservice.service;

import com.mtattab.emailservice.model.ResponseRestModel;

public interface SMTPService {

    ResponseRestModel sendEmail(String toEmail, String subject, String messageText, boolean isHtmlEnabled);
}
