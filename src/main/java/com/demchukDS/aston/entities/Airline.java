package com.demchukDS.aston.entities;

import com.demchukDS.aston.src.AirlineType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "airline_name")
    String airlineName;

    @Column(name = "airline_code")
    String airlineCode;

    @Column (name = "airline_type")
    @Enumerated(EnumType.STRING)
    AirlineType airlineType;

    @OneToMany(mappedBy = "airline", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<FlightInfo> flightInfo;

    @OneToOne (cascade = CascadeType.ALL)
    private Aircraft aircraft;

    @ManyToMany (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "airline_service",
            joinColumns = @JoinColumn(name = "airline_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services;

    public Airline() {
    }

    public Airline(String airlineName, String airlineCode, AirlineType airlineType) {
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.airlineType = airlineType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AirlineType getAirlineType() {
        return airlineType;
    }

    public void setAirlineType(AirlineType airlineType) {
        this.airlineType = airlineType;
    }

    public Set<FlightInfo> getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Set<FlightInfo> flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
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
                "id=" + id +
                ", airlineName='" + airlineName + '\'' +
                ", airlineCode='" + airlineCode + '\'' +
                ", airlineType=" + airlineType +
                ", flightInfo=" + flightInfo +
                ", aircraft=" + aircraft +
                ", services=" + services +
                '}';
    }
}
