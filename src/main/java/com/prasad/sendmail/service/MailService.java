package com.prasad.sendmail.service;

import com.prasad.sendmail.model.BillingReport;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface MailService {

    void sendMail(String client);

    default String getReportHtml(String client, List<BillingReport> weeklyBillingReports, List<BillingReport> monthlyBillingReports) {

        StringBuilder htmlReport = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border:1px solid black;\n" +
                "}\n" +
                "\n" +
                "p.note {\n" +
                "\tcolor:red;\n" +
                "    text-align: center;\n" +
                "font-size: 85%\n" +
                "}\n" +
                "</style>\n" +
                "<body>\n" +
                "\n" +
                "<p>Hello Team,</p>\n" +
                "<p>Please find below, the weekly billing report.</p>\n");

        htmlReport.append("<table style=\"width:50%\"><tr><tr>" +
                "<tr>\n" +
                "    <th>From Date</th>\n" +
                "    <th>To Date</th>\n" +
                "    <th>Environment</th>\n" +
                "    <th>Count</th>\n" +
                "  </tr>");

        weeklyBillingReports.forEach(billingRecord -> {
            htmlReport.append("<tr>\n" + "<td>").append(LocalDate.now().minusDays(7)).append("</td>\n").append("<td>").append(LocalDate.now())
                    .append("</td>\n" + "<td>").append(billingRecord.getEnvironment()).append("</td>\n" + "<td>")
                    .append(billingRecord.getTransactionCount()).append("</td>\n" + "</tr>");
        });

        monthlyBillingReports.forEach(billingRecord -> {
            htmlReport.append("<tr>\n" + "<td>").append(LocalDate.now().withDayOfMonth(1)).append("</td>\n").append("<td>").append(LocalDate.now())
                    .append("</td>\n" + "<td>").append(billingRecord.getEnvironment()).append("</td>\n" + "<td>")
                    .append(billingRecord.getTransactionCount()).append("</td>\n" + "</tr>");
        });

        htmlReport.append("\n");
        htmlReport.append("</table>\n");

//        Uncomment the below code if needed
//        htmlReport.append("<p>");
//        monthlyBillingRecordsOfClient.forEach(billingRecord -> {
//            htmlReport.append("Total from the beginning of month for " + billingRecord.getEnvironmentId() + " - " + billingRecord.getAmount())
//                    .append("<br>");
//        });
//        htmlReport.append("</p>\n");

        htmlReport.append("<p>Thanks & Regards, <br> Prasad - Billing</p>\n");
        htmlReport.append("<br>\n" +
                "<p class=\"note\"><strong>This is an automated email. Please do not respond as the mailbox is not monitored.</p>\n");
        htmlReport.append("</body>\n" +
                "</html>");
        return htmlReport.toString();
    }


    default String getReportHtmlForGmail(String client, List<BillingReport> weeklyBillingReports, List<BillingReport> monthlyBillingReports) {

        StringBuilder htmlReport = new StringBuilder("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "<p>Hello Team,</p>\n" +
                "<p>Please find below, the weekly billing report.</p>\n");

        htmlReport.append("<table style=\"width:50%;border:1px solid black\"><tr><tr>" +
                "<tr>\n" +
                "    <th style=\"border:1px solid black\">From Date</th>\n" +
                "    <th style=\"border:1px solid black\">To Date</th>\n" +
                "    <th style=\"border:1px solid black\">Environment</th>\n" +
                "    <th style=\"border:1px solid black\">Count</th>\n" +
                "  </tr>");

        weeklyBillingReports.forEach(billingRecord -> {
            htmlReport.append("<tr>\n" + "<td style=\"border:1px solid black\">").append(LocalDate.now().minusDays(7)).append("</td>\n").append("<td style=\"border:1px solid black\">").append(LocalDate.now())
                    .append("</td>\n" + "<td style=\"border:1px solid black\">").append(billingRecord.getEnvironment()).append("</td>\n" + "<td style=\"border:1px solid black\">")
                    .append(billingRecord.getTransactionCount()).append("</td>\n" + "</tr>");
        });

        monthlyBillingReports.forEach(billingRecord -> {
            htmlReport.append("<tr>\n" + "<td style=\"border:1px solid black\">").append(LocalDate.now().withDayOfMonth(1)).append("</td>\n").append("<td style=\"border:1px solid black\">").append(LocalDate.now())
                    .append("</td>\n" + "<td style=\"border:1px solid black\">").append(billingRecord.getEnvironment()).append("</td>\n" + "<td style=\"border:1px solid black\">")
                    .append(billingRecord.getTransactionCount()).append("</td>\n" + "</tr>");
        });

        htmlReport.append("\n");
        htmlReport.append("</table>\n");

//        Uncomment the below code if needed
//        htmlReport.append("<p>");
//        monthlyBillingRecordsOfClient.forEach(billingRecord -> {
//            htmlReport.append("Total from the beginning of month for " + billingRecord.getEnvironmentId() + " - " + billingRecord.getAmount())
//                    .append("<br>");
//        });
//        htmlReport.append("</p>\n");

        htmlReport.append("<p>Thanks & Regards, <br> Prasad - Billing</p>\n");
        htmlReport.append("<br>\n" +
                "<p style=\"font-size: 85%; color:red; text-align: center\"><strong>This is an automated email. Please do not respond as the mailbox is not monitored.</p>\n");
        htmlReport.append("</body>\n" +
                "</html>");
        return htmlReport.toString();
    }

}
