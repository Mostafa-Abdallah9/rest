package com.pioneers.rest.amaan.repositories;

import com.pioneers.rest.amaan.models.entities.TerminalSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TerminalSubscriptionRepository extends JpaRepository<TerminalSubscription, Long> {

    boolean existsByTerminalIdAndServiceCodeAndSubscriptionActiveTrue(String terminalId, String serviceCode);

    boolean existsByTerminalIdAndServiceCode(String terminalId, String serviceCode);

    Optional<TerminalSubscription> findByTerminalIdAndServiceCode(String terminalId, String serviceCode);

    List<TerminalSubscription> findByTerminalId(String terminalId);

    List<TerminalSubscription> findByServiceCode(String serviceCode);

    List<TerminalSubscription> findBySubscriptionActiveTrueAndNextDueDateLessThanEqual(LocalDate date);

    List<TerminalSubscription> findBySubscriptionActiveTrueAndOutstandingArrearsGreaterThan(
            java.math.BigDecimal amount);
}