package com.prasad.sendmail.service;

import com.prasad.sendmail.dto.BillingRecordRequestBody;
import com.prasad.sendmail.model.BillingRecord;
import com.prasad.sendmail.model.BillingReport;
import com.prasad.sendmail.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public List<BillingRecord> getAllBillingRecords() {
        return billingRepository.findAll();
    }

    @Override
    public BillingRecord addBillingRecord(BillingRecordRequestBody billingRecordRequestBody) {
        BillingRecord billingRecord = new BillingRecord(billingRecordRequestBody.getClient(),
                billingRecordRequestBody.getEnvironment(),billingRecordRequestBody.getCount());
        return billingRepository.save(billingRecord);
    }

    @Override
    public List<BillingReport> getWeeklyData(String client) {
        return billingRepository.findWeeklyData(client);
    }


    @Override
    public List<BillingReport> getMonthlyData(String client) {
        return billingRepository.findMonthlyData(client);
    }
}
