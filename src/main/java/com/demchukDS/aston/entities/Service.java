package com.demchukDS.aston.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "name_of_service")
    private String nameOfService;

    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "services",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Passenger> passengers;

    @ManyToMany(mappedBy = "services", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Airline> airlines;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                "id=" + id +
                ", nameOfService='" + nameOfService + '\'' +
                ", price=" + price +
                ", passengers=" + passengers +
                ", airlines=" + airlines +
                '}';
    }
}
