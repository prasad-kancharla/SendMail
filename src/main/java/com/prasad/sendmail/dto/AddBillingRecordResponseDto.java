package com.prasad.sendmail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.prasad.sendmail.model.BillingRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBillingRecordResponseDto {
    private HttpStatus code;
    private String message;
    @JsonProperty("Billing Record")
    private BillingRecord billingRecord;
}
