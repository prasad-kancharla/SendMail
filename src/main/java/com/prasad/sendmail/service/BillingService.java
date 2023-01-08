package com.prasad.sendmail.service;


import com.prasad.sendmail.dto.BillingRecordRequestBody;
import com.prasad.sendmail.model.BillingRecord;
import com.prasad.sendmail.model.BillingReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillingService {

    List<BillingRecord> getAllBillingRecords();

    BillingRecord addBillingRecord(BillingRecordRequestBody billingRecordRequestBody);


    List<BillingReport> getWeeklyData(String client);
    List<BillingReport> getMonthlyData(String client);
}
