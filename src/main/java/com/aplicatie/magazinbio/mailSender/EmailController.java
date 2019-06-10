package com.aplicatie.magazinbio.mailSender;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping(path = "/email")
public class EmailController {

    @Autowired
    private JavaMailSender sender;

    @PostMapping(path = "/sendemail", produces = "application/json")
    String home() {
        try {

            return "Email Sent!";
        } catch (Exception ex) {
            return "Error in sending email: " + ex;
        }
    }

    public void sendEmail(String email, String text, String subject) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email);
        helper.setText(text);
        helper.setSubject(subject);

        sender.send(message);
    }
}