package com.prasad.sendmail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingRecordRequestBody {
    private String client;
    private String environment;
    private Integer count;
}
