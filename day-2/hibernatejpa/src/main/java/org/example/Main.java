package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("started");
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        Employee emp =new Employee();
        emp.setId(1);
        emp.setName("renuka");
        emp.setCity("solapur");

        //creating session
        Session session= factory.openSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        session.close();
        System.out.println("data inserted");

    }
}