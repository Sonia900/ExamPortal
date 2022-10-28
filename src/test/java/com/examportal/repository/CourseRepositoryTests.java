package com.examportal.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.StudentEntity;

@DataJpaTest
public class CourseRepositoryTests {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	@DisplayName("Junit")
	public void givenCourseObject_whenSavedCourse_thenReturnedSavedCourse()
		{
			//given
			CourseEntity course = CourseEntity.builder()
											  .courseName("java")
											  .courseDuration("3 months")
											  .courseFees("2000") 
											  .build();
			
			//when
			CourseEntity savedcourse = courseRepository.save(course);
			
			//then
			Assertions.assertThat(savedcourse).isNotNull();
			Assertions.assertThat(savedcourse.getCourseId()).isGreaterThan(0);
		}
	@Test
	@DisplayName("Junit test for get course by Id operation")
	public void givenCourseObject_whenFindById_thenReturnedCourseObject()
	{
		//given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();

		
		//when
		CourseEntity savedcourse = courseRepository.save(course);
		CourseEntity courseById=this.courseRepository.findById(savedcourse.getCourseId()).get();
		
		//then
		Assertions.assertThat(courseById).isNotNull();
		Assertions.assertThat(courseById.getCourseId()).isGreaterThan(0);
		Assertions.assertThat(courseById.getCourseId()).isEqualTo(savedcourse.getCourseId());
	}
	
	@Test
	@DisplayName("Junit test for get all course operation")
	public void givenCourseList_whenFindAllCourseList_then()
	{
		//given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		//given
		CourseEntity course1 = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
				courseRepository.save(course);
				courseRepository.save(course1);
		
		//when
		List<CourseEntity> courseList=this.courseRepository.findAll();
		//then
		Assertions.assertThat(courseList.size()).isNotNull();
		Assertions.assertThat(courseList.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("Junit test for update course operation")
	public void givenCourseObject_whenUpdatedCourse_thenReturnedUpdatedCourse()
	{
		//given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		CourseEntity savedcourse=this.courseRepository.save(course);
		
		//when
		CourseEntity coursedb=this.courseRepository.findById(course.getCourseId()).get();
		coursedb.setCourseFees("3000");
		CourseEntity updatedCourse=courseRepository.save(coursedb);
		
		//then
		Assertions.assertThat(updatedCourse.getCourseFees()).isEqualTo("3000");

	}
	
	@Test
	@DisplayName("Junit test for delete course operation")
	public void givenCourseObject_whenDeletedCourse_thenDeletedCourseNull()
	{
		//given
				CourseEntity course = CourseEntity.builder()
						  .courseName("java")
						  .courseDuration("3 months")
						  .courseFees("2000") 
						  .build();
		CourseEntity savedcourse=courseRepository.save(course);
		
		//when
		CourseEntity coursedb=this.courseRepository.findById(course.getCourseId()).get();
		this.courseRepository.delete(coursedb);
		Optional<CourseEntity> coursedb2=this.courseRepository.findById(course.getCourseId());
		//then
		Assertions.assertThat(coursedb2).isEmpty();
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenCourseName_whenFindByJPQLIndex_thenReturnCourseObject()
	{
		//Given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		CourseEntity saved=courseRepository.save(course);
		//When
		CourseEntity savedcourse=courseRepository.findByCourseNameWithIndexParam(course.getCourseName());
		//Then
		Assertions.assertThat(savedcourse).isNotNull();
		Assertions.assertThat(savedcourse.getCourseId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenCourseName_whenFindByJPQLNamed_thenReturnCourseObject()
	{
		//Given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		CourseEntity saved=courseRepository.save(course);
		//When
		CourseEntity savedcourse=courseRepository.findByCourseNameWithNamedParam(course.getCourseName());
		//Then
		Assertions.assertThat(savedcourse).isNotNull();
		Assertions.assertThat(savedcourse.getCourseId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenCourseName_whenFindByJPQLNativeIndexed_thenReturnCourseObject()
	{
		//Given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		CourseEntity saved=courseRepository.save(course);
		//When
		CourseEntity savedcourse=courseRepository.findByCourseNameWithNativeQueryIndexParam(course.getCourseName());
		//Then
		Assertions.assertThat(savedcourse).isNotNull();
		Assertions.assertThat(savedcourse.getCourseId()).isGreaterThan(0);
	}
//	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenCourseName_whenFindByJPQLNativeNamed_thenReturnCourseObject()
	{
		//Given
		CourseEntity course = CourseEntity.builder()
				  .courseName("java")
				  .courseDuration("3 months")
				  .courseFees("2000") 
				  .build();
		CourseEntity saved=courseRepository.save(course);
		//When
		CourseEntity savedcourse=courseRepository.findByCourseNameWithNativeQueryNamedParam(course.getCourseName());
		//Then
		Assertions.assertThat(savedcourse).isNotNull();
		Assertions.assertThat(savedcourse.getCourseId()).isGreaterThan(0);
	}
	

	

}
