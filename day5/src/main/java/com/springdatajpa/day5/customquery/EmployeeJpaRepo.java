package com.springdatajpa.day5.customquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeJpaRepo  extends JpaRepository<Employee, Integer > {
    public Collection<Employee> findByDesignation(String designation);
    public Employee findByFnameAndLname(String fname, String lname);

    public Employee findByFnameOrLname(@Param("fname") String fname, @Param("lname") String lname);

    public Employee findByFnameIs(String fname);

    public Employee findByFnameEquals(String fname);

    public List<Employee> findBySalaryBetween(long l, long l2);
    @Query("from Employee")
    public List<Employee> getAllUser();

    @Query("select e from Employee e where e.lname= :name")
    public Employee findByLname(@Param("name") String lname);

    @Query(value = "select * from Eployee where salary between :l1 and :l2", nativeQuery = true)
    public List<Employee> findSalaryBetween(@Param("l1") long l1,@Param("l2") long l2);

}
