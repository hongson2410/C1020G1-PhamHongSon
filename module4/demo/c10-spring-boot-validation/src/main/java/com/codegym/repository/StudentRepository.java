package com.codegym.repository;

import com.codegym.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByOrderByDateOfBirthDesc();
}
