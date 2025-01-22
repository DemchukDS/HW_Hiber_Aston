package com.demchukDS.aston.entities;

import com.demchukDS.aston.DataManager;
import com.demchukDS.aston.src.AirlineType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airlines")
public class Airline extends DataManager {

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "airline_code")
    private String airlineCode;

    @Column(name = "airline_type")
    private String airlineType;

    @OneToMany (mappedBy = "airline", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<FlightInfo> flights = new HashSet<>();

    public void addFlight(FlightInfo flight) {
        flights.add(flight);
        flight.setAirline(this);
    }

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private Set<Aircraft> aircrafts = new HashSet<>();

    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        aircraft.setAirline(this);
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "airline_service",
    joinColumns = @JoinColumn(name = "airline_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services = new HashSet<Service>();

    public void addService(Service service) {
        services.add(service);
    }

    public Airline() {
    }

    public Airline(String createdAt, String updatedAt, String airlineName, String airlineCode, AirlineType airlineType) {
        super(createdAt, updatedAt);
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.airlineType = airlineType.toString();
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getAirlineType() {
        return airlineType;
    }

    public void setAirlineType(String airlineType) {
        this.airlineType = airlineType;
    }

    public Set<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(Set<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public Set<FlightInfo> getFlights() {
        return flights;
    }

    public void setFlights(Set<FlightInfo> flights) {
        this.flights = flights;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineName='" + airlineName + '\'' +
                ", airlineCode='" + airlineCode + '\'' +
                ", airlineType='" + airlineType + '\'' +
                ", flights=" + flights +
                ", aircrafts=" + aircrafts +
                ", services=" + services +
                '}';
    }
}
