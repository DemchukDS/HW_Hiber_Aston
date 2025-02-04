package com.demchukDS.aston.entities;

import com.demchukDS.aston.DataManager;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aircrafts")
public class Aircraft extends DataManager {

    @Column(name = "aircraft_brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "registration_number")
    private String registrationNumber;

    @OneToMany(mappedBy = "aircraft", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<FlightInfo> flights = new HashSet<>();

    public void addFlightInfoToAircraft(FlightInfo flight) {
        flights.add(flight);
        flight.setAircraft(this);
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public Aircraft() {
    }

    public Aircraft(String createdAt, String updatedAt, String brand, String model, String registrationNumber) {
        super(createdAt, updatedAt);
        this.brand = brand;
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
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

    public Set<FlightInfo> getFlights() {
        return flights;
    }

    public void setFlights(Set<FlightInfo> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", flights=" + flights +
                ", airline=" + airline +
                '}';
    }
}
