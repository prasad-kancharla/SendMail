package com.prasad.sendmail.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String client;
    private String environment;
    @Column(name = "transaction_count")
    private Integer transactionCount;
    private LocalDate date;


    public BillingRecord(String client, String environment, Integer transactionCount) {
        this.client = client;
        this.environment = environment;
        this.transactionCount = transactionCount;
        this.date = LocalDate.now();
    }
}
