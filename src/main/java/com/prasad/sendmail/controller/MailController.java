package com.prasad.sendmail.controller;

import com.prasad.sendmail.dto.MailResponse;
import com.prasad.sendmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    @Qualifier("SMTPService")
    private MailService smtpService;

    @Autowired
    private MailService graphService;


    @PostMapping("/smtp/{client}")
    public MailResponse sendMailSMTP(@PathVariable String client) {

        smtpService.sendMail(client);
        return new MailResponse(HttpStatus.OK, "Mail sent successfully to the client " + client);

    }

    @PostMapping("/graph/{client}")
    public MailResponse sendMailGraph(@PathVariable String client) {

        graphService.sendMail(client);
        return new MailResponse(HttpStatus.OK, "Mail sent successfully to the client " + client);

    }
}
