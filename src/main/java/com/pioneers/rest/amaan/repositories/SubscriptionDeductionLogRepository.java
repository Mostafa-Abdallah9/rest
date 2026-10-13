package com.pioneers.rest.amaan.repositories;

import com.pioneers.rest.amaan.models.entities.SubscriptionDeductionLog;
import com.pioneers.rest.amaan.models.enums.DeductionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubscriptionDeductionLogRepository extends JpaRepository<SubscriptionDeductionLog, Long> {
    List<SubscriptionDeductionLog> findByTerminalId(String terminalId);

    List<SubscriptionDeductionLog> findByServiceCode(String serviceCode);

    List<SubscriptionDeductionLog> findByStatus(DeductionStatus status);

    List<SubscriptionDeductionLog> findByTerminalIdAndServiceCode(String terminalId, String serviceCode);

    List<SubscriptionDeductionLog> findBySubscription_Id(Long subscriptionId);

}
