package com.pioneers.rest.amaan.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service_configurations")
public class ServiceConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "service_code", nullable = false, unique = true, length = 50)
    private String serviceCode;

    @Column(name = "service_name", nullable = false, length = 100)
    private String serviceName;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Column(name = "default_recurring_amount",
            nullable = false, precision = 12, scale = 2)
    private BigDecimal defaultRecurringAmount;

    @Column(name = "recurring_period_days", nullable = false)
    private Integer recurringPeriodDays;

    @Column(name = "description", length = 500)
    private String description;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "service_whitelisted_models",
            joinColumns = @JoinColumn(name = "service_id", nullable = false)
    )
    @Column(name = "device_model", nullable = false, length = 100)
    @Builder.Default
    private List<String> whitelistedDeviceModels = new ArrayList<>();

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
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
