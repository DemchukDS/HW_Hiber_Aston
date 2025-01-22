package com.demchukDS.aston.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "service_description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "services",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Passenger> passengers = new HashSet<Passenger>();

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.getServices().add(this);
    }

    @ManyToMany(mappedBy = "services", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Airline> airlines = new HashSet<Airline>();

    public void addAirline(Airline airline) {
        airlines.add(airline);
        airline.getServices().add(this);
    }

    public Service() {
    }

    public Service(String description, Double price) {
        this.description = description;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(Set<Airline> airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", passengers=" + passengers +
                ", airlines=" + airlines +
                '}';
    }
}
