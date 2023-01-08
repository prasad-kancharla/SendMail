package com.prasad.sendmail.repository;

import com.prasad.sendmail.model.BillingRecord;
import com.prasad.sendmail.model.BillingReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BillingRepository extends JpaSpecificationExecutor<BillingRecord>, JpaRepository<BillingRecord,Integer>, Repository<BillingRecord, Integer> {

    @Query(value = "SELECT b.client AS client, b.environment AS environment, SUM(b.transactionCount) AS transactionCount FROM BillingRecord b WHERE b.date > date_trunc('month', now()) AND b.client = ?1 GROUP BY 1,2")
    List<BillingReport> findMonthlyData(String client);

    @Query(value = "SELECT b.client AS client, b.environment AS environment, SUM(b.transactionCount) AS transactionCount FROM BillingRecord b WHERE b.date > CURRENT_DATE - 7 AND b.client = ?1 GROUP BY 1,2")
    List<BillingReport> findWeeklyData(String client);

}

