package com.sms.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
