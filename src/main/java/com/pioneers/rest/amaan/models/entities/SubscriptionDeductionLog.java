package com.pioneers.rest.amaan.models.entities;

import com.pioneers.rest.amaan.models.enums.DeductionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription_deduction_logs")
public class SubscriptionDeductionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subscription_id", nullable = false)
    private TerminalSubscription subscription;

    @Column(name = "terminal_id", nullable = false, length = 50)
    private String terminalId;

    @Column(name = "service_code", nullable = false, length = 50)
    private String serviceCode;

    @Column(name = "requested_amount",
            nullable = false, precision = 12, scale = 2)
    private BigDecimal requestedAmount;

    @Column(name = "deducted_amount",
            nullable = false, precision = 12, scale = 2)
    private BigDecimal deductedAmount;

    @Column(name = "remaining_arrears", nullable = false, precision = 12, scale = 2)
    private BigDecimal remainingArrears;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private DeductionStatus status;

    @Column(name = "gle_transaction_id", length = 100)
    private String gleTransactionId;

    @Column(name = "error_message", length = 500)
    private String errorMessage;

    @Column(name = "executed_at", nullable = false, updatable = false)
    private LocalDateTime executedAt;

    @PrePersist
    protected void onCreate() {
        if (executedAt == null) {
            executedAt = LocalDateTime.now();
        }
    }

}
