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
import java.time.LocalDate;
import java.util.List;

public class HwTask2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            List<Passenger> passengers = session.createQuery("select e from Passenger e", Passenger.class).list();

            for (Passenger passenger : passengers) {
                System.out.println("Passenger Name: " + passenger.getPassport().getFirstName() +
                        " " + passenger.getPassport().getLastName());
            }

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
