package com.example.GoCloudCamp.services;

import com.example.GoCloudCamp.models.Config;
import com.example.GoCloudCamp.repositories.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ConfigService {
    private final ConfigRepository configRepository;
    private final ServiceService serviceService;

    @Autowired
    public ConfigService(ConfigRepository configRepository, ServiceService serviceService) {
        this.configRepository = configRepository;
        this.serviceService = serviceService;
    }

    public List<Config> findAllByService(String name){
        return configRepository.findAllByService(name);
    }

    public Optional<Config> findByName(String name){
        return configRepository.findByService(name);
    }

    public Optional<Config> findByNameAndActive(String name, Boolean active){
        return configRepository.findByServiceAndActive(name, active);
    }

    public Optional<Config> findByNameAndVersion(String name, Integer version){
        return configRepository.findByServiceAndVersion(name, version);
    }

    @Transactional
    public void save(Config config){
        com.example.GoCloudCamp.models.Service service = serviceService.findByName(config.getService()).orElse(null);
        if (service != null) {
            service.getConfigs().add(config);
            config.setServiceId(service);
        }
        serviceService.save(service);
        configRepository.save(config);
    }

    @Transactional
    public void delete(Config config){
        configRepository.delete(config);
    }

    @Transactional
    public void update(int id, Config config){
        config.setId(id);
        configRepository.save(config);
    }

    public List<Config> findAll(){
        return configRepository.findAll();
    }
}