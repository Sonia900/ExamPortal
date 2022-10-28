package com.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.entity.CourseEntity;





public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
	
		//JPQL with index param
		@Query("select s from CourseEntity s where s.courseName=?1")
		CourseEntity findByCourseNameWithIndexParam(String courseName);


		//JPQL with named param
		@Query("select s from CourseEntity s where s.courseName=:courseName")
		CourseEntity findByCourseNameWithNamedParam(@Param("courseName") String courseName);
//		
		//JPQL with native query with index param
		@Query(value="select * from Course s where s.course_Name=?1",nativeQuery = true)
		CourseEntity findByCourseNameWithNativeQueryIndexParam(String courseName);

		//JPQL with native query with named param
		@Query(value="select * from course s where s.course_Name=:courseName",nativeQuery = true)
		CourseEntity findByCourseNameWithNativeQueryNamedParam(@Param("courseName") String courseName);

}
