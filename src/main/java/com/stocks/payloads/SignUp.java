package com.stocks.payloads;

import java.util.Date;

import lombok.Data;

@Data
public class SignUp {

    private String username;
    private String email;
    private String password;
    private Date dateOfBirth;
    private String phoneNumber;
    private String gender;
   
}
