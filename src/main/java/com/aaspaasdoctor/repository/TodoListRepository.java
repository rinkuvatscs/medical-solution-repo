package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList	, Integer>{

}
