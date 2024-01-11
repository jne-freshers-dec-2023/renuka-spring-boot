package com.day3.springdatajpa.implementspringjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpringJPARepo extends JpaRepository<Student, Integer> {

}
