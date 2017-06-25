package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.TodoList;
import com.aaspaasdoctor.repository.TodoListRepository;

@Service
@Transactional
public class TodoListServiceImpl {

	@Autowired
	private TodoListRepository todoListRepository;

	public List<TodoList> getAllTodoMessages() {
		return (List<TodoList>) todoListRepository.findAll();
	}

	public TodoList addTodoList(TodoList todoList) {
		return todoListRepository.save(todoList);
	}

	public List<TodoList> findByPatientId(Integer patientId) {
		return todoListRepository.findByPatientId(patientId);
	}

	public List<TodoList> findByDoctorId(Integer doctorId) {
		return todoListRepository.findByDoctorId(doctorId);
	}

	public TodoList updateTodoListMessage(TodoList todoList) {
		TodoList tempTodoList = todoListRepository.findOne(todoList.getId());

		if (tempTodoList != null && todoList.getMessage() != null) {
			tempTodoList.setMessage(todoList.getMessage());
			return todoListRepository.save(tempTodoList);

		} else {
			return new TodoList();
		}

	}

	public TodoList deleteByTodoId(Integer todoId) {

		TodoList todoList = todoListRepository.findOne(todoId);
		if (todoList != null) {
			todoListRepository.delete(todoList);
			return todoList;
		} else {
			return new TodoList();
		}
	}
}
