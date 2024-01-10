package com.learnspringjpahibernate.springjpahibernate.day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
@Repository
public class JDBCRepository {

    @Autowired
    private  JdbcTemplate jdbctemplate;
    public  String INSERT_QUERY= """
                 INSERT INTO Employee
                        VALUES(?, ?, ?, ?);
            """;
    private   String DELETE_QUERY= """
                DELETE FROM Employee
                WHERE id= ?
            """;

    private String SELECTBYID= """
                SELECT * FROM Employee
                WHERE id=?;
            """;

    public  void insert(Employee empinsert){
        jdbctemplate.update(INSERT_QUERY,
                empinsert.getId(), empinsert.getName(),empinsert.getDesignation(),empinsert.getSalary());
    }

    public  void  deleteById(int id){
        jdbctemplate.update(DELETE_QUERY,id);
    }

    public Employee findById(int id){
       return jdbctemplate.queryForObject(SELECTBYID,new BeanPropertyRowMapper<>(Employee.class),id);
    }
}
