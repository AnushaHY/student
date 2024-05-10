package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServicesImpl implements StudentServices
{
	StudentRepository repo;

	public StudentServicesImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addStudent(Student s) {
		repo.save(s);
		return "objects are created";
	}

	@Override
	public Student viewstudent(int rollNo) {
		Student st=repo.findByRollNo(rollNo);
		return st;
	}

	@Override
	public String updateStudent(Student s) {
		repo.save(s);
		return "objects are updated";
	}

	@Override
	public String DeleteStudent(int rollNo) {
		Student s=repo.findByRollNo(rollNo);
		repo.delete(s);
		return "objects are deleted";
	}

	@Override
	public List<Student> viewAllStudent() {
		List<Student> st=repo.findAll();
		return st;
	}

	
	
	

}
