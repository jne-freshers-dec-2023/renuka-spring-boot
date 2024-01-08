package com.learnspringjpahibernate.springjpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JDBCCommandRunner implements CommandLineRunner {
    @Autowired
      JDBCRepository jdbcrepo;

    @Override
    public void run(String... args) throws Exception {
        jdbcrepo.insert();
    }
}
