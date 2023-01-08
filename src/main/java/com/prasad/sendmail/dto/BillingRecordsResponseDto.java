package com.prasad.sendmail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prasad.sendmail.model.BillingRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingRecordsResponseDto {

    private HttpStatus code;
    private String message;
    @JsonProperty("Billing Records List")
    private List<BillingRecord> billingRecords;
}
