package com.examportal.repository;


import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examportal.entity.StudentEntity;
import com.examportal.repository.StudentRepository;

@DataJpaTest
public class StudentRepositoryTests {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Test
	@DisplayName("Junit test for save student operation")
	public void given_when_then()
	{
		//given
		StudentEntity student = StudentEntity.builder()
											 .studentName("Charlie")
											 .studentAge(23)
											 .studentEmail("charlie@gmail.com")
											 .studentGender("male")
											 .studentPassword("charlie@123")
											 .build();
		
		//when
		StudentEntity savedstudent = studentRepository.save(student);
		
		//then
		Assertions.assertThat(savedstudent).isNotNull();
		Assertions.assertThat(savedstudent.getStudentId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("Junit test for get student by Id operation")
	public void givenStudentObject_whenFindById_thenReturnedStudentObject()
	{
		//given
		StudentEntity student = StudentEntity.builder()
											 .studentName("Charlie")
											 .studentAge(23)
											 .studentEmail("charlie@gmail.com")
											 .studentGender("male")
											 .studentPassword("charlie@123")
											 .build();
		
		//when
		StudentEntity savedstudent = studentRepository.save(student);
		StudentEntity studentById=this.studentRepository.findById(savedstudent.getStudentId()).get();
		
		//then
		Assertions.assertThat(studentById).isNotNull();
		Assertions.assertThat(studentById.getStudentId()).isGreaterThan(0);
		Assertions.assertThat(studentById.getStudentId()).isEqualTo(savedstudent.getStudentId());
	}
	
	@Test
	@DisplayName("Junit test for get all students operation")
	public void givenStudentList_whenFindAllStudentsList_then()
	{
		//given
		StudentEntity student = StudentEntity.builder()
											 .studentName("Charlie")
											 .studentAge(23)
											 .studentEmail("charlie@gmail.com")
											 .studentGender("male")
											 .studentPassword("charlie@123")
											 .build();
		//given
				StudentEntity student2 = StudentEntity.builder()
													 .studentName("Alpha")
													 .studentAge(23)
													 .studentEmail("Alpha@gmail.com")
													 .studentGender("male")
													 .studentPassword("Alpha@123")
													 .build();
				studentRepository.save(student);
				studentRepository.save(student2);
		
		//when
		List<StudentEntity> studentList=this.studentRepository.findAll();
		//then
		Assertions.assertThat(studentList.size()).isNotNull();
		Assertions.assertThat(studentList.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("Junit test for update student operation")
	public void givenStudentObject_whenUpdatedStudent_thenReturnedUpdatedStudent()
	{
		//given
		StudentEntity student = StudentEntity.builder()
											 .studentName("Charlie")
											 .studentAge(23)
											 .studentEmail("charlie@gmail.com")
											 .studentGender("male")
											 .studentPassword("charlie@123")
											 .build();
		StudentEntity savedstudent=this.studentRepository.save(student);
		
		//when
		StudentEntity studentdb=this.studentRepository.findById(student.getStudentId()).get();
		studentdb.setStudentEmail("charlie123@gmail.com");
		StudentEntity updatedStudent=studentRepository.save(studentdb);
		
		//then
		Assertions.assertThat(updatedStudent.getStudentEmail()).isEqualTo("charlie123@gmail.com");

	}
	
	@Test
	@DisplayName("Junit test for delete student operation")
	public void givenStudentObject_whenDeletedStudent_thenDeletedStudentNull()
	{
		//given
		StudentEntity student = StudentEntity.builder()
											 .studentName("Charlie")
											 .studentAge(23)
											 .studentEmail("charlie@gmail.com")
											 .studentGender("male")
											 .studentPassword("charlie@123")
											 .build();
		StudentEntity savedstudent=studentRepository.save(student);
		
		//when
		StudentEntity studentdb=this.studentRepository.findById(student.getStudentId()).get();
		this.studentRepository.delete(studentdb);
		Optional<StudentEntity> studentdb2=this.studentRepository.findById(student.getStudentId());
		//then
		Assertions.assertThat(studentdb2).isEmpty();
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenStudentName_whenFindByJPQLIndex_thenReturnStudentObject()
	{
		//Given
		StudentEntity student = StudentEntity.builder()
				 .studentName("Charlie")
				 .studentAge(23)
				 .studentEmail("charlie@gmail.com")
				 .studentGender("male")
				 .studentPassword("charlie@123")
				 .build();
		StudentEntity saved=studentRepository.save(student);
		//When
		StudentEntity savedstudent=studentRepository.findByStudentNameAndstudentEmailWithIndexParam(student.getStudentName(),student.getStudentEmail());
		//Then
		Assertions.assertThat(savedstudent).isNotNull();
		Assertions.assertThat(savedstudent.getStudentId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenStudentName_whenFindByJPQLNamed_thenReturnStudentObject()
	{
		//Given
		StudentEntity student = StudentEntity.builder()
				 .studentName("Charlie")
				 .studentAge(23)
				 .studentEmail("charlie@gmail.com")
				 .studentGender("male")
				 .studentPassword("charlie@123")
				 .build();
		StudentEntity saved=studentRepository.save(student);
		//When
		StudentEntity savedstudent=studentRepository.findByStudentNameAndstudentEmailWithNamedParam(student.getStudentName(),student.getStudentEmail());
		//Then
		Assertions.assertThat(savedstudent).isNotNull();
		Assertions.assertThat(savedstudent.getStudentId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenStudentName_whenFindByJPQLNativeIndexed_thenReturnStudentObject()
	{
		//Given
		StudentEntity student = StudentEntity.builder()
				 .studentName("Charlie")
				 .studentAge(23)
				 .studentEmail("charlie@gmail.com")
				 .studentGender("male")
				 .studentPassword("charlie@123")
				 .build();
		StudentEntity saved=studentRepository.save(student);
		//When
		StudentEntity savedstudent=studentRepository.findByStudentNameAndstudentEmailWithNativeQueryIndexParam
				(student.getStudentName(),student.getStudentEmail());
		//Then
		Assertions.assertThat(savedstudent).isNotNull();
		Assertions.assertThat(savedstudent.getStudentId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenStudentName_whenFindByJPQLNativeNamed_thenReturnStudentObject()
	{
		//Given
		StudentEntity student = StudentEntity.builder()
				 .studentName("Charlie")
				 .studentAge(23)
				 .studentEmail("charlie@gmail.com")
				 .studentGender("male")
				 .studentPassword("charlie@123")
				 .build();
		StudentEntity saved=studentRepository.save(student);
		//When
		StudentEntity savedstudent=studentRepository.findByStudentNameAndstudentEmailWithNativeQueryNamedParam(student.getStudentName(),student.getStudentEmail());
		//Then
		Assertions.assertThat(savedstudent).isNotNull();
		Assertions.assertThat(savedstudent.getStudentId()).isGreaterThan(0);
	}
	
	
	
	

}

