package com.imt.spring.infra.repository;

import com.imt.spring.infra.model.Course;
import com.imt.spring.infra.model.Sillon;
import com.imt.spring.infra.model.Travaux;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	@Query(value = "SELECT * FROM infra.course", nativeQuery = true)
    List<Course> getCourses();
}
