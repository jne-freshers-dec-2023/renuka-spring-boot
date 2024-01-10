package com.learnspringjpahibernate.springjpahibernate;

import com.learnspringjpahibernate.springjpahibernate.day2.Employee;
import com.learnspringjpahibernate.springjpahibernate.day2.JDBCRepository;
import com.learnspringjpahibernate.springjpahibernate.day2.JPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("package com.day2")

@SpringBootApplication
public class SpringJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaHibernateApplication.class, args);
		JPARepository jpaRepository = new JPARepository();
		jpaRepository.insert(new Employee(5,"mic","Digital Marketing",400000));
					

	}
}
