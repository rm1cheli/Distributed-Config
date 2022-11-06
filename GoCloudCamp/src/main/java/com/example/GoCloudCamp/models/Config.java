package com.example.GoCloudCamp.models;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name = "Config")
@TypeDef(name = "json", typeClass = JsonType.class)
public class Config {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name")
    @NotEmpty(message = "enter program name")
    private String service;

    @Type(type = "json")
    @Column(name = "data", columnDefinition = "json")
    @NotEmpty(message = "enter program config")
    private Map<String, Object> data;

    @Column(name = "version")
    @NotNull
    private int version;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id")
    private Service serviceId;

    public Config(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", data=" + data +
                ", time=" + version +
                ", active=" + active +
                ", serviceId=" + serviceId +
                '}';
    }
}