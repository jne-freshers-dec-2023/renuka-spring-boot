package org.example.inheritancemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class IndiaMain {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println("it's working");

        TeamIndia ti=new TeamIndia();
        ti.setFname("Ravi");
        ti.setLname("takre");

        BatsMan bat1=new BatsMan();
        bat1.setBatting_hand("right");
        bat1.setHighest_score("87");
        bat1.setFname("Mahi");
        bat1.setLname("Dhoni");
        BatsMan bat2=new BatsMan();
        bat2.setBatting_hand("left");
        bat2.setHighest_score("90");
        bat2.setFname("Virat");
        bat2.setLname("Kholi");

        Boller boll1=new Boller();
        boll1.setBest_figure("8/10");
        boll1.setBowler_hand("left");
        boll1.setFname("Rahul");
        boll1.setLname("Davi");

        Boller boll2=new Boller();
        boll2.setBowler_hand("right");
        boll2.setBest_figure("9/10");
        boll2.setFname("uvraj");
        boll2.setLname("Singh");


        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(ti);
        session.save(bat1);
        session.save(bat2);
        session.save(boll1);
        session.save(boll2);


        tx.commit();
        session.close();
    }
}
