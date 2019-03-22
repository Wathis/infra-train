package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Sillon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
