package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Calendar;

public interface CalendarRepository extends CrudRepository<Calendar, Integer> {

	java.util.List<Calendar> findByPId(Integer pId);

	java.util.List<Calendar> findByDId(Integer dId);

}
