package com.day3.springdatajpa.implementspringjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JPACommandRunner implements CommandLineRunner {
    @Autowired
    private SpringJPARepo springjparepo;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("executing");
        //inserting data into a table
        springjparepo.save(new Student(1,"renuka",21));
        springjparepo.save(new Student(2,"shambu",22));
        springjparepo.save(new Student(3,"manju",24));
        springjparepo.save(new Student(4,"vaishoo",25));

        //deleting row based on id
        springjparepo.deleteById(3);
        //selection data based on Id
        Optional<Student> optional= springjparepo.findById(3);

        if (optional.isPresent()){
            System.out.println(optional.get());
        }
        else {
            System.out.println("record not found!!");
        }

        //getRefrenceById(id)
        System.out.println(springjparepo.getReferenceById(2).getId());;

    }
}
