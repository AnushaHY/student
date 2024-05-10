package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Student;

public interface StudentServices {
	public String addStudent(Student s);
	public Student viewstudent(int rollNo);
	public String updateStudent(Student s);
	public String DeleteStudent(int rollNo);
	public List<Student> viewAllStudent();
	
	
}
