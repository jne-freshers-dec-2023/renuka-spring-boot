//package org.example.mappingtypes.onetoone;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class App {
//    public static void main(String[] args) {
//        Configuration cfg= new Configuration();
//        cfg.configure("hibernate.cfg.xml");
//        SessionFactory factory= cfg.buildSessionFactory();
//
//        //creating session factory in a single line
//        //SessionFactory factory1= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        Questions q1=new Questions();
//        q1.setQ_id(1232);
//        q1.setQuestion("What is java?");
//
//        Answer a1= new Answer();
//
//        a1.setA_id(213);
//        a1.setAns("Java is programming Lang.");
//        a1.setQuestion(q1);
//
//
//
//        Session session= factory.openSession();
//        //session.beginTransaction();
//        Transaction tx = session.beginTransaction();
//        session.save(q1);
//        session.save(a1);
//        tx.commit();
//        session.close();
//        System.out.println("data is inserted");
//
//    }
//}
