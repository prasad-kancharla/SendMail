package com.prasad.sendmail.controller;

import com.prasad.sendmail.dto.AddBillingRecordResponseDto;
import com.prasad.sendmail.dto.BillingRecordRequestBody;
import com.prasad.sendmail.dto.BillingRecordsResponseDto;
import com.prasad.sendmail.model.BillingRecord;
import com.prasad.sendmail.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billingRecords")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping
    public BillingRecordsResponseDto getAllBillingRecords() {
        List<BillingRecord> billingRecordList = billingService.getAllBillingRecords();
        return  new BillingRecordsResponseDto(HttpStatus.OK,"Billing Records fetched successfully", billingRecordList);
    }

    @PostMapping
    public AddBillingRecordResponseDto addBillingRecord(@RequestBody BillingRecordRequestBody billingRecordRequestBody) {
        BillingRecord billingRecord = billingService.addBillingRecord(billingRecordRequestBody);
        return new AddBillingRecordResponseDto(HttpStatus.CREATED, "Billing record added successfully", billingRecord);
    }
}
