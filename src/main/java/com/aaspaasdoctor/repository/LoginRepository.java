package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

}
