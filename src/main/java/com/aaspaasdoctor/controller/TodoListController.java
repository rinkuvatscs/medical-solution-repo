package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.TodoList;
import com.aaspaasdoctor.service.TodoListServiceImpl;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoListController {

	@Autowired
	TodoListServiceImpl todoListServiceImpl ;
	
	
	@RequestMapping("/")
	public List<TodoList> getAllTodoMessages(){
		return todoListServiceImpl.getAllTodoMessages();
	}
}
