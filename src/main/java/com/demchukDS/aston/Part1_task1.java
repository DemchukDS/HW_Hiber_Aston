package com.demchukDS.aston;

import com.demchukDS.aston.entities.*;
import com.demchukDS.aston.src.AirlineType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class Part1_task1 {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try {
            tx.begin();

            Passenger passenger = new Passenger(
                    "Dmitriy",
                    "Demchuk",
                    "Belarus",
                    Date.valueOf("1995-06-06")
                    );
            Airline airline = new Airline("Belavia", "989DS", AirlineType.INTERNATIONAL);
            Aircraft aircraft = new Aircraft("Boeing", "737-800", "2384XC-7");
            FlightInfo flightInfo = new FlightInfo(
                    "1",
                    "2025-02-14",
                    "20:35",
                    "2025-02-15",
                    "02:35"
            );
            Ticket ticket = new Ticket(4398541);


            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        finally {
            if (session.isOpen()) {
                session.close();
                sf.close();
            }
        }
    }
}
