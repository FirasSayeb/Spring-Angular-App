package com.example.demo.model;

import com.example.demo.Repositories.MailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
public class MailController {
    @Autowired
    public JavaMailSender javaMailSender;
    @Autowired
    MailRepository mailRepository;

    @RequestMapping("/mail")
    public void sendEmail(@RequestBody Mail mail) throws Exception {
        Mail m =new Mail(mail.destinatire,mail.objet, mail.message);
mailRepository.save(m);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("firassayeb2@gmail.com");
            message.setTo(mail.destinatire);
            message.setText(mail.message);
            message.setSubject(mail.objet);
            javaMailSender.send(message);


       
    }

}


