package com.learnspringjpahibernate.springjpahibernate.day2;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JPARepository {
//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    public  void insert(Employee emp){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("isert qeurvf");
        System.out.println(entityManager);
        entityManager.merge(emp);

    }
    public Employee findById(long id){
//        return entityManager.find(Employee.class,id);
        return null;
    }



}
