package org.example.mappingtypes.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class ManyToManyMain {
    public static void main(String[] args) {
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);

        Employees emp1=new Employees();
        Employees emp2= new Employees();
        Employees emp3= new Employees();
        Employees e1,e2;

        emp1.setEid(1);
        emp1.setName("Renuka");
        emp2.setEid(2);
        emp2.setName("Mani");
        emp3.setEid(3);
        emp3.setName("Vaishoo");

        Projects p1= new Projects();
        Projects p2= new Projects();
        p1.setPid(121);
        p1.setPname("ForWood");
        p2.setPid(453);
        p2.setPname("BookMyShow");

        List<Employees> elist=new ArrayList<>();
        List<Projects> plist=new ArrayList<>();

        elist.add(emp1);
        elist.add(emp2);
        elist.add(emp3);

        plist.add(p1);
        plist.add(p2);

        p1.setEmployees(elist);
        p2.setEmployees(elist);

        emp1.setProjects(plist);
        p1.setEmployees(elist);
        emp2.setProjects(plist);
        p2.setEmployees(elist);
        emp3.setProjects(plist);


        //session 1
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
//        session.save(emp1);
//        session.save(p1);
//        session.save(emp2);
//        session.save(emp3);
//        session.save(p2);

        //below queries fired on First level cache
        e1=(Employees) session.get(Employees.class, 2);
        System.out.println(e1.toString());
        e2=(Employees) session.get(Employees.class,2);
        System.out.println(e2);

       // printing projects
//        e1.getProjects().stream().forEach((a)->{
//            System.out.println(a.getPname());
//        });
        //printing e1 name,id


        tx.commit();
        System.out.println("inserted data");
        session.close();

        //session 2
        //this session uses se
        Session session2= factory.openSession();
        Transaction tx1= session2.beginTransaction();
        //fetching same data again from database not from first level cache beacuase this is different session
        e1=(Employees) session2.get(Employees.class, 2);
        //printing e1 name,id
        System.out.println(e1.toString());
        tx1.commit();
        session2.close();

    }
}
