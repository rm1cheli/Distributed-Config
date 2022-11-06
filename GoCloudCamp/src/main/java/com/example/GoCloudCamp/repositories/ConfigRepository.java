package com.example.GoCloudCamp.repositories;

import com.example.GoCloudCamp.models.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {
    Optional<Config> findByService(String name);
    List<Config> findAllByService(String name);
    Optional<Config> findByServiceAndActive(String name, Boolean active);
    Optional<Config> findByServiceAndVersion(String name, Integer version);
}