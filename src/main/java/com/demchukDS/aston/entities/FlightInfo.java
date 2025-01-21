package com.demchukDS.aston.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "")
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "flight_number")
    private String flightNo;

    @Column(name = "date_of_departure")
    private String dateOfDeparture;

    @Column(name = "time_of_departure")
    private String timeOfDeparture;

    @Column(name = "date_of_arrival")
    private String dateOfArrival;

    @Column(name = "time_of_arrival")
    private String timeOfArrival;

    @OneToMany(mappedBy = "flightInfo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Ticket> ticket;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    public FlightInfo() {
    }

    public FlightInfo(String flightNo, String dateOfDeparture, String timeOfDeparture, String dateOfArrival, String timeOfArrival) {
        this.flightNo = flightNo;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", dateOfDeparture=" + dateOfDeparture +
                ", timeOfDeparture=" + timeOfDeparture +
                ", dateOfArrival=" + dateOfArrival +
                ", timeOfArrival=" + timeOfArrival +
                ", ticket=" + ticket +
                ", airline=" + airline +
                ", aircraft=" + aircraft +
                '}';
    }
}
