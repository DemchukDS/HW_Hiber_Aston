package com.demchukDS.aston.entities;

import com.demchukDS.aston.DataManager;
import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket extends DataManager {

    @Column(name = "ticket_number")
    private String ticketNumber;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_info_id")
    private FlightInfo flightInfo;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "passport_id")
    private Passport passport;

    public Ticket() {
    }

    public Ticket(String createdAt, String updatedAt, String ticketNumber) {
        super(createdAt, updatedAt);
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", passenger=" + passenger +
                ", flightInfo=" + flightInfo +
                ", passport=" + passport +
                '}';
    }
}
