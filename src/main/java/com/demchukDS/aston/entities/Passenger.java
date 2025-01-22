package com.demchukDS.aston.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "allergy")
    private String allergy;

    @Column(name = "ammount_of_bagage")
    private Double ammountOfBagage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(mappedBy = "passenger", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Ticket> tickets = new HashSet<Ticket>();

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setPassenger(this);
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "passenger_service",
    joinColumns = @JoinColumn(name = "passenger_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services = new HashSet<Service>();

    public void addService(Service service) {
        services.add(service);
    }

    public Passenger() {
    }

    public Passenger(String allergy, Double ammountOfBagage) {
        this.allergy = allergy;
        this.ammountOfBagage = ammountOfBagage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Double getAmmountOfBagage() {
        return ammountOfBagage;
    }

    public void setAmmountOfBagage(Double ammountOfBagage) {
        this.ammountOfBagage = ammountOfBagage;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", allergy='" + allergy + '\'' +
                ", ammountOfBagage=" + ammountOfBagage +
                ", passport=" + passport +
                ", tickets=" + tickets +
                ", services=" + services +
                '}';
    }
}
