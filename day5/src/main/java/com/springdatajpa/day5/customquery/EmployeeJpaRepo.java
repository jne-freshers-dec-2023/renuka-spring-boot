package com.springdatajpa.day5.customquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeJpaRepo  extends JpaRepository<Employee, Integer > {
    public Collection<Employee> findByDesignation(String designation);
    public Employee findByFnameAndLname(String fname, String lname);

    public Employee findByFnameOrLname(@Param("fname") String fname, @Param("lname") String lname);

    public Employee findByFnameIs(String fname);

    public Employee findByFnameEquals(String fname);

    public  Collection<Employee> findBySalaryBetween(long l,long l2);



}
