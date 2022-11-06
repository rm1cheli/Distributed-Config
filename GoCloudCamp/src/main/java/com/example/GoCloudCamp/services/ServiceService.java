package com.example.GoCloudCamp.services;

import com.example.GoCloudCamp.models.Service;
import com.example.GoCloudCamp.repositories.ServiceRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    public Optional<Service> findByName(String name){
        return serviceRepository.findByName(name);
    }
    
    @Transactional
    public void save(Service service){

        serviceRepository.save(service);
    }

    @Transactional
    public void delete(Service service){
        serviceRepository.delete(service);
    }
}