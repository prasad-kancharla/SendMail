package com.prasad.sendmail.service;

import com.prasad.sendmail.model.BillingReport;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
@Slf4j
public class SMTPService implements MailService{

    @Autowired
    private BillingService billingService;

    @Override
    public void sendMail(String client) {

        String to = "kdgkp98@gmail.com";
        String from = "kancharlaguruprasad@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kancharlaguruprasad@gmail.com", "xnvzeliiqdpjodza");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Billing Report - " + client);
            List<BillingReport> weeklyBillingReports = billingService.getWeeklyData(client);
            List<BillingReport> monthlyBillingReports = billingService.getMonthlyData(client);
            String mailBody = getReportHtmlForGmail(client,weeklyBillingReports,monthlyBillingReports);
            message.setContent(mailBody,"text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }
    }

}
