package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.TodoList;
import com.aaspaasdoctor.repository.TodoListRepository;

@Service
public class TodoListServiceImpl {

	@Autowired
	private TodoListRepository todoListRepository ;
	
	public List<TodoList> getAllTodoMessages() {
		return (List<TodoList>) todoListRepository.findAll();
	}
}
