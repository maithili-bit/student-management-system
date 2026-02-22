package com.maithili.studentapp.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.maithili.studentapp.entity.Student;
import com.maithili.studentapp.repository.StudentRepository;


@Service

public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository repo;
	
	public StudentServiceImpl(StudentRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<Student> getAllStudents() {
	    return repo.findAll();
	}
	
	
	

	@Override
	public Student getStudentById(Long id) {
	    return repo.findById(id)
	            .orElseThrow(() -> new com.maithili.studentapp.exception.StudentNotFoundException(id));
	}
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}




	@Override
	public Student updateStudent(Long id, Student student) {
		
		Student existingStudent = repo.findById(id).orElseThrow(() -> new RuntimeException("student not found with id" +id));
		
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setCourse(student.getCourse());
		
		return repo.save(existingStudent);
	}
	
	
	

}
