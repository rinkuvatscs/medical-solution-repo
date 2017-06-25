package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.TodoList;
import com.aaspaasdoctor.service.TodoListServiceImpl;

@RestController
@RequestMapping(value = "/api/todo")
public class TodoListController {

	@Autowired
	TodoListServiceImpl todoListServiceImpl;

	@RequestMapping("/")
	public List<TodoList> getAllTodoMessages() {
		return todoListServiceImpl.getAllTodoMessages();
	}

	// Translate

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/todolist")
	@ResponseBody
	public TodoList addToDoListForPatient(@RequestBody TodoList todoList) {
		return todoListServiceImpl.addTodoList(todoList);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/todolist/patient/{pId}/id")
	@ResponseBody
	public List<TodoList> getToDoListforPatient(@PathVariable int pId) {
		return todoListServiceImpl.findByPatientId(pId);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/todolist")
	@ResponseBody
	public TodoList updateToDoListForPatient(@RequestBody TodoList todoList) {
		return todoListServiceImpl.updateTodoListMessage(todoList);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/delete/todoList/{todoId}")
	@ResponseBody
	public TodoList deleteToDoListForPatient(@PathVariable Integer todoId) {
		return todoListServiceImpl.deleteByTodoId(todoId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/todolist/doctor/{dId}/id")
	@ResponseBody
	public List<TodoList> getToDoListforDoctor(@PathVariable int dId) {
		return todoListServiceImpl.findByDoctorId(dId);
	}

}
