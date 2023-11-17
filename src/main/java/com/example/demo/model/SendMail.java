package com.example.demo.model;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SendMail {
    @Autowired
public JavaMailSender javaMailSender;
public String   sendEmail(String dest,String text,String obj){
    SimpleMailMessage message=new SimpleMailMessage();
    message.setFrom("firassayeb2@gmail.com");
    message.setTo(dest);
    message.setText(text);
    message.setSubject(obj);
    javaMailSender.send(message);
    return "Mail send seccussfully";

}
}
