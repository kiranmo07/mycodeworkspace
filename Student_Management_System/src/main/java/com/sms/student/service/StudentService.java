package com.sms.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sms.student.entity.Student;

@Service
public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student findStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long id);
}
