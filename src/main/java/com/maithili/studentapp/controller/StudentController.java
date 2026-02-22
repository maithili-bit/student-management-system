package com.maithili.studentapp.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maithili.studentapp.entity.Student;
import com.maithili.studentapp.service.StudentService;

import jakarta.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/api/students")

public class StudentController {
	
	private final StudentService service;
	
	
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
	    return service.getAllStudents();
	}
	
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") Long id){
		return service.getStudentById(id);
	}
	
	@PostMapping
	public Student addStudent(@Valid @RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		service.deleteStudent(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
	    return service.updateStudent(id, student);
	}
	


	
	

}
