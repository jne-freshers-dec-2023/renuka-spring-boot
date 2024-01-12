package com.springdatajpa.day5;

import com.springdatajpa.day5.customquery.Employee;
import com.springdatajpa.day5.customquery.EmployeeJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day5Application {

	public static void main(String[] args) {
		SpringApplication.run(Day5Application.class, args);
		System.out.println("it's working");

	}

}
