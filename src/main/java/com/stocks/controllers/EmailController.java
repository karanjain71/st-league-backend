package com.stocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entities.EmailDetails;
import com.stocks.services.EmailService;

@RestController
@RequestMapping("/api/v1/auth")
public class EmailController {
	
	@Autowired 
	private EmailService emailService;
	 
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details){
    	
        String status = emailService.sendMail(details);
        return status;
    }
 
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details){
    	
        String status = emailService.sendMailWithAttachment(details);
        return status;
    }
}
