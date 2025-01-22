package com.demchukDS.aston.entities;

import com.demchukDS.aston.DataManager;
import com.demchukDS.aston.src.SexType;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passports")
public class Passport extends DataManager {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private SexType sexType;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "passport", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Passenger passenger;

    @OneToMany(mappedBy = "passport", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Ticket> tickets = new HashSet<Ticket>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setPassport(this);
    }

    public Passport(String createdAt, String updatedAt, String firstName, String lastName, SexType sexType, String nationality, Date dateOfBirth) {
        super(createdAt, updatedAt);
        this.firstName = firstName;
        this.lastName = lastName;
        this.sexType = sexType;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
    }

    public Passport() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sexType=" + sexType +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passenger=" + passenger +
                ", tickets=" + tickets +
                '}';
    }
}
