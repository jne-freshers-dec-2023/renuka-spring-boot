package com.springdatajpa.day5.customquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class EmployeeCommandRunner implements CommandLineRunner {
    @Autowired
    EmployeeJpaRepo employeeJpaRepo;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside command runner");
        employeeJpaRepo.saveAll(Arrays.asList(
                new Employee(1001,"James","Kim","HR",2000000),
                new Employee(1002,"Elizabeth","Patel","Admin",3000000),
                new Employee(1003,"Robert","Müller","Testing",10000000),
                new Employee(1004,"Victoria","Rossi","Development",2500000),
                new Employee(1005,"David","Garcia","QA",6000000),
                new Employee(1006,"Isabel","Silva","Support",4000000),
                new Employee(1007,"Michael","Wilson","Development",56000000),
                new Employee(1008,"Maria","Johnson","Finance",3700000),
                new Employee(1009,"Thomas","Brown","HR",7800000),
                new Employee(1010,"Maria","Jones","Development",34000000))
        );
        System.out.println("data inserted!!");
        //fetching all data
        Collection<Employee> elsit= employeeJpaRepo.findAll();
        //printing all data
        System.out.println("All Employees in Employee Table:-");
        elsit.forEach(e-> System.out.println(e));

        Collection<Employee> empdesg= employeeJpaRepo.findByDesignation("HR");
        System.out.println("List of employees whose designation is HR");
        empdesg.forEach(d-> System.out.println(d));

        //finding employees whose fname is Michael and lname is Wilson
        System.out.println(employeeJpaRepo.findByFnameAndLname("Michael","Wilson"));

        //finding employees whose fname is Michael or lname is Johnson
        System.out.println("finding employees whose fname is Michael or lname is Johnson");
        System.out.println(employeeJpaRepo.findByFnameOrLname("Jones","Johnson"));

        //finding employee whose name is David
        System.out.println(employeeJpaRepo.findByFnameIs("David"));

        ////finding employee whose name is David
        System.out.println(employeeJpaRepo.findByFnameEquals("David"));

        List<Employee> empsalary= (List<Employee>) employeeJpaRepo.findBySalaryBetween(2500000,7800000);
        System.out.println("Salary between 2500000 and 7800000");
        empsalary.forEach(e-> System.out.println(e));



    }
}
