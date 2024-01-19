package org.example.mappingtypes.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        QuestionsOneToMany q1= new QuestionsOneToMany();
        q1.setQ_id(121);
        q1.setQuestion("what is html?");

        AnswersOneToMany a1= new AnswersOneToMany();
        a1.setA_id(345);
        a1.setAns("stands for HyperText markup language");
        a1.setQuestion(q1);

        AnswersOneToMany a2= new AnswersOneToMany();
        a2.setA_id(765);
        a2.setAns("It is used to build web sites");
        a2.setQuestion(q1);

        List<AnswersOneToMany> list= new ArrayList<>();
        list.add(a1);
        list.add(a2);

        q1.setAnswers(list);



        Session session= factory.openSession();
        //session.beginTransaction();
        Transaction tx = session.beginTransaction();
        session.save(q1);
        session.save(a1);
        session.save(a2);
        tx.commit();
        session.close();
        System.out.println("data is inserted");

    }
}
