package com.demchukDS.aston.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flights_info")
public class FlightInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "flight_number")
    private String flightNo;

    @Column(name = "date_of_departure")
    private Date dateOfDeparture;

    @Column(name = "time_of_departure")
    private Time timeOfDeparture;

    @Column(name = "date_of_arrival")
    private Date dateOfArrival;

    @Column(name = "time_of_arrival")
    private Time timeOfArrival;

    @OneToMany(mappedBy = "flightInfo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Ticket> tickets = new HashSet<Ticket>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setFlightInfo(this);
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    public FlightInfo() {
    }

    public FlightInfo(String flightNo, Date dateOfDeparture, Time timeOfDeparture, Date dateOfArrival, Time timeOfArrival) {
        this.flightNo = flightNo;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Time getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(Time timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Time getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(Time timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "id='" + id + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", dateOfDeparture=" + dateOfDeparture +
                ", timeOfDeparture=" + timeOfDeparture +
                ", dateOfArrival=" + dateOfArrival +
                ", timeOfArrival=" + timeOfArrival +
                ", tickets=" + tickets +
                ", airline=" + airline +
                ", aircraft=" + aircraft +
                '}';
    }
}
