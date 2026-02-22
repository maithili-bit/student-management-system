package com.maithili.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maithili.studentapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
		
	}


