package com.examportal.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.SubjectEntity;
import com.examportal.entity.SubjectEntity;

@DataJpaTest
public class SubjectRepositoryTests {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	private SubjectEntity subject;
	
	@Test
	@DisplayName("Junit test for save subject operation")
	public void given_when_then()
	{
		//given
		 subject = SubjectEntity.builder().subjectName("java")
				 						   .subjectDescription("java full stack developement")
											 .build();
		
		//when
		 SubjectEntity savedsubject = subjectRepository.save(subject);
		
		//then
		Assertions.assertThat(savedsubject).isNotNull();
		Assertions.assertThat(savedsubject.getSubjectId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Junit test for get subject by Id operation")
	public void givensubjectObject_whenFindById_thenReturnedsubjectObject()
	{
		//given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();

		
		//when
		SubjectEntity savedsubject = subjectRepository.save(subject);
		SubjectEntity subjectById=this.subjectRepository.findById(savedsubject.getSubjectId()).get();
		
		//then
		Assertions.assertThat(subjectById).isNotNull();
		Assertions.assertThat(subjectById.getSubjectId()).isGreaterThan(0);
		Assertions.assertThat(subjectById.getSubjectId()).isEqualTo(savedsubject.getSubjectId());
	}
	
	@Test
	@DisplayName("Junit test for get all subjects operation")
	public void givensubjectList_whenFindAllsubjectsList_then()
	{
		//given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();

		//given
		SubjectEntity subject1 = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();

				subjectRepository.save(subject);
				subjectRepository.save(subject1);
		
		//when
		List<SubjectEntity> subjectList=this.subjectRepository.findAll();
		//then
		Assertions.assertThat(subjectList.size()).isNotNull();
		Assertions.assertThat(subjectList.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("Junit test for update subject operation")
	public void givensubjectObject_whenUpdatedsubject_thenReturnedUpdatedsubject()
	{
		//given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();

		SubjectEntity savedsubject=this.subjectRepository.save(subject);
		
		//when
		SubjectEntity subjectdb=this.subjectRepository.findById(subject.getSubjectId()).get();
		subjectdb.setSubjectDescription("java FullStack developement from scratch");
		SubjectEntity updatedsubject=subjectRepository.save(subjectdb);
		
		//then
		Assertions.assertThat(updatedsubject.getSubjectDescription()).isEqualTo("java FullStack developement from scratch");

	}
	
	@Test
	@DisplayName("Junit test for delete subject operation")
	public void givensubjectObject_whenDeletedsubject_thenDeletedsubjectNull()
	{
		//given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();
		SubjectEntity savedsubject=subjectRepository.save(subject);
		
		//when
		SubjectEntity subjectdb=this.subjectRepository.findById(subject.getSubjectId()).get();
		this.subjectRepository.delete(subjectdb);
		Optional<SubjectEntity> subjectdb2=this.subjectRepository.findById(subject.getSubjectId());
		//then
		Assertions.assertThat(subjectdb2).isEmpty();
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenSubjectName_whenFindByJPQLIndex_thenReturnSubjectObject()
	{
		//Given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();
		SubjectEntity saved=subjectRepository.save(subject);
		//When
		SubjectEntity savedsubject=subjectRepository.findBySubjectNameWithIndexParam(subject.getSubjectName());
		//Then
		Assertions.assertThat(savedsubject).isNotNull();
		Assertions.assertThat(savedsubject.getSubjectId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenSubjectName_whenFindByJPQLNamed_thenReturnSubjectObject()
	{
		//Given
		subject = SubjectEntity.builder().subjectName("java")
				   .subjectDescription("java full stack developement")
					 .build();
		SubjectEntity saved=subjectRepository.save(subject);
		//When
		SubjectEntity savedsubject=subjectRepository.findBySubjectNameWithIndexParam(subject.getSubjectName());
		//Then
		Assertions.assertThat(savedsubject).isNotNull();
		Assertions.assertThat(savedsubject.getSubjectId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenSubjectName_whenFindByJPQLNativeIndexed_thenReturnSubjectObject()
	{
		//Given
		subject = SubjectEntity.builder()
								.subjectName("java")
								.subjectDescription("java full stack developement")
								.build();
		SubjectEntity saved=subjectRepository.save(subject);
		//When
		SubjectEntity savedsubject=subjectRepository.findBySubjectNameWithNativeQueryIndexParam(subject.getSubjectName());
		//Then
		Assertions.assertThat(savedsubject).isNotNull();
		Assertions.assertThat(savedsubject.getSubjectId()).isGreaterThan(0);
	}
//	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenSubjectName_whenFindByJPQLNativeNamed_thenReturnSubjectObject()
	{
		//Given
		subject = SubjectEntity.builder()
				.subjectName("java")
				.subjectDescription("java full stack developement")
				.build();
		SubjectEntity saved=subjectRepository.save(subject);
		//When
		SubjectEntity savedcourse=subjectRepository.findBySubjectNameWithNativeQueryNamedParam(subject.getSubjectName());
		//Then
		Assertions.assertThat(savedcourse).isNotNull();
		Assertions.assertThat(savedcourse.getSubjectId()).isGreaterThan(0);
	}
	


}
