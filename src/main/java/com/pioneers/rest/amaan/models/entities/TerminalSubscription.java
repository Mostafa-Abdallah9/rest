package com.pioneers.rest.amaan.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(
        name = "terminal_subscriptions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_terminal_service",
                        columnNames = {"terminal_id", "service_code"}
                )
        }
)
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TerminalSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "terminal_id", nullable = false, length = 50)
    private String terminalId;

    @Column(name = "service_code", nullable = false, length = 50)
    private String serviceCode;

    @Column(name = "join_date", nullable = false, updatable = false)
    private LocalDateTime joinDate;

    @Column(name = "disenrollment_date")
    private LocalDateTime disenrollmentDate;

    @Column(name = "next_due_date", nullable = false)
    private LocalDate nextDueDate;

    @Column(name = "recurring_amount",
            nullable = false, precision = 12, scale = 2)
    private BigDecimal recurringAmount;

    @Column(name = "outstanding_arrears",
            nullable = false, precision = 12, scale = 2)
    private BigDecimal outstandingArrears;

    @Column(name = "is_subscription_active", nullable = false)
    private boolean subscriptionActive;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        if (createdAt == null) {
            createdAt = now;
        }

        if (joinDate == null) {
            joinDate = now;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
