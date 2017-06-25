package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;


import com.aaspaasdoctor.entity.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList	, Integer>{
	
	java.util.List<TodoList> findByPatientId(Integer patientId) ;
	
	java.util.List<TodoList> findByDoctorId(Integer doctorId) ;
}
