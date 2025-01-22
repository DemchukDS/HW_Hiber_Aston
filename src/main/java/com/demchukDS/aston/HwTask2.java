package com.demchukDS.aston;

import com.demchukDS.aston.entities.*;
import com.demchukDS.aston.src.AirlineType;
import com.demchukDS.aston.src.SexType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.Time;

public class HwTask2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Passport passport = new Passport(
                    "Dmitriy",
                    "Demchuk",
                    SexType.MALE,
                    "Belarus",
                    Date.valueOf("1995-06-06")
            );

            Passenger passenger = new Passenger("no", 21.3d);

            Airline airline = new Airline(
                    "Belavia",
                    "BRU",
                    AirlineType.INTERNATIONAL
                    );

            Aircraft aircraft = new Aircraft(
                    "Boeing",
                    "737-800",
                    "2384XC7"
            );

            FlightInfo flightInfo = new FlightInfo(
                    "22012025TH",
                    Date.valueOf("2025-01-22"),
                    Time.valueOf("20:06:00"),
                    Date.valueOf("2025-01-23"),
                    Time.valueOf("02:12:00")
            );

            Ticket ticket = new Ticket("432FS195");

            Service service = new Service("Upgrade to business", 100.0d);

            passenger.addService(service);
            passenger.addTicket(ticket);
            passport.addTicket(ticket);
            aircraft.addFlightInfoToAircraft(flightInfo);
            airline.addAircraft(aircraft);
            airline.addService(service);
            airline.addFlight(flightInfo);
            flightInfo.addTicket(ticket);
            service.addAirline(airline);
            service.addPassenger(passenger);
            passenger.setPassport(passport);

            session.save(passport);
            session.save(airline);
            session.save(aircraft);
            session.save(flightInfo);
            session.save(ticket);
            session.save(service);
            session.save(passenger);

            tx.commit();
        }
        catch (Exception e) {
            if(tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session.isOpen()) {
                session.close();
                sessionFactory.close();
            }
        }
    }
}
