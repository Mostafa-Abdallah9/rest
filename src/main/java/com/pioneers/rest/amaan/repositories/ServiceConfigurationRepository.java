package com.pioneers.rest.amaan.repositories;

import com.pioneers.rest.amaan.models.entities.ServiceConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ServiceConfigurationRepository extends JpaRepository<ServiceConfiguration, Long> {

    Optional<ServiceConfiguration> findByServiceCodeAndActive(String serviceCode, boolean active);

    Optional<ServiceConfiguration> findByServiceCode(String serviceCode);

    boolean existsByServiceCode(String serviceCode);
}
