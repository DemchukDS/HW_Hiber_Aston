package com.demchukDS.aston.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "brand")
    String brand;

    @Column(name = "model")
    String model;

    @Column(name = "registration_number")
    String registrationNumber;

    @OneToMany(mappedBy = "aircraft", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<FlightInfo> flightInfoSet;

    @OneToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Airline airline;

    public Aircraft() {
    }

    public Aircraft(String brand, String model, String registrationNumber) {
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Set<FlightInfo> getFlightInfoSet() {
        return flightInfoSet;
    }

    public void setFlightInfoSet(Set<FlightInfo> flightInfoSet) {
        this.flightInfoSet = flightInfoSet;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", flightInfoSet=" + flightInfoSet +
                ", airline=" + airline +
                '}';
    }
}
