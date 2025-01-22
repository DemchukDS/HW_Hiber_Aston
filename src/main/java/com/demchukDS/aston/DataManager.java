package com.demchukDS.aston;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class DataManager {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passports_seq")
    @SequenceGenerator(name = "passports_seq", sequenceName = "passports_seq", allocationSize = 1)
    private Long id;

    @Transient
    private String createdAt;

    @Transient
    private String updatedAt;

    public DataManager(String createdAt, String updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public DataManager() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
