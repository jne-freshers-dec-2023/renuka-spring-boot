package com.learnspringjpahibernate.springjpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class JDBCRepository {
    @Autowired
    private JdbcTemplate springjdbctemplate;

    private  String INSERT_QUERY=
            """
                INSERT INTO Employee
                        VALUES (2, 'renuka', 'software',400000);
                    
            """;

    public  void insert(){
        springjdbctemplate.update(INSERT_QUERY);
    }
       

}
