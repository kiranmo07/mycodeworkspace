package com.sms.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.student.dao.StudentRepository;
import com.sms.student.entity.Student;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	private StudentRepository studentRepository;
	public StudentManagementSystemApplication(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student student = new Student("kiran","mo","kiran@gmail.com");
//		Student student1 = new Student("luffy","D","luffy@gmail.com");
//		Student student2 = new Student("zoro","roronoa","zoro@gmail.com");
//		studentRepository.save(student);
//		studentRepository.save(student1);
//		studentRepository.save(student2);
		
	}

}
