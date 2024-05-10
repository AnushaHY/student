package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentServices;

@RestController
@RequestMapping("/st")
public class StudentController {
	StudentServices ser;

	public StudentController(StudentServices ser) {
		super();
		this.ser = ser;
	}
	
	@PostMapping("/add")
	public String addStudent(@RequestBody Student s)
	{
		if(ser.viewstudent(s.getRollNo())==null)
		{
			String msg=ser.addStudent(s);
			return msg;
		}
		else
		{
	        return "this user alredy present";
		}
		
	}
	
	@GetMapping("{rollNo}")
	public Student viewStudent(@PathVariable int  rollNo)
	{
		Student st=ser.viewstudent(rollNo);
		return st;
	}
	
	@GetMapping("")
	public List<Student> viewAllStudent()
	{
		List<Student> st=ser.viewAllStudent();
		return st;
	}
	
	@PutMapping("{rollNo}")
	public String updateStudent(@RequestBody Student s)
	{
		String msg=ser.updateStudent(s);
		return msg;
	}
	
	@DeleteMapping("{rollNo}")
	public String DeletesStudent(@PathVariable int  rollNo)
	{
		if(ser.viewstudent(rollNo)==null)
		{
			return "pls enter the correct rollNo";
		}
		else
		{
		String st=ser.DeleteStudent(rollNo);
		return st;
	}
	
	}

}
