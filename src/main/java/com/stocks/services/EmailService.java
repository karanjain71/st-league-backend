package com.stocks.services;

import com.stocks.db1.entities.EmailDetails;

public interface EmailService {

	String sendMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
