package com.stocks.services;

import com.stocks.entities.EmailDetails;

public interface EmailService {

	String sendMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
