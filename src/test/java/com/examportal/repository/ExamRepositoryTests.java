package com.examportal.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examportal.entity.ExamEntity;
import com.examportal.entity.SubjectEntity;


@DataJpaTest
public class ExamRepositoryTests {
	
	@Autowired
	private ExamRepository examRepository;
	
	private ExamEntity exam;
	
	@Test
	@DisplayName("Junit test for save exam operation")
	public void given_when_then()
	{
		//given
		 exam = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();
		
		//when
		 ExamEntity savedexam = examRepository.save(exam);
		
		//then
		Assertions.assertThat(savedexam).isNotNull();
		Assertions.assertThat(savedexam.getExamId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Junit test for get exam by Id operation")
	public void givenexamObject_whenFindById_thenReturnedexamObject()
	{
		//given
		 exam = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();

		
		//when
		ExamEntity savedexam = examRepository.save(exam);
		ExamEntity examById=this.examRepository.findById(savedexam.getExamId()).get();
		
		//then
		Assertions.assertThat(examById).isNotNull();
		Assertions.assertThat(examById.getExamId()).isGreaterThan(0);
		Assertions.assertThat(examById.getExamId()).isEqualTo(savedexam.getExamId());
	}
	
	@Test
	@DisplayName("Junit test for get all exams operation")
	public void givenexamList_whenFindAllexamsList_then()
	{
		//given
		 exam = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();

		//given
		 ExamEntity exam1 = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();
				examRepository.save(exam);
				examRepository.save(exam1);
		
		//when
		List<ExamEntity> examList=this.examRepository.findAll();
		//then
		Assertions.assertThat(examList.size()).isNotNull();
		Assertions.assertThat(examList.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("Junit test for update exam operation")
	public void givenexamObject_whenUpdatedexam_thenReturnedUpdatedexam()
	{
		//given
		//given
		 exam = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();

		ExamEntity savedexam=this.examRepository.save(exam);
		
		//when
		ExamEntity examdb=this.examRepository.findById(exam.getExamId()).get();
		examdb.setExamduration("60 mins");
		ExamEntity updatedexam=examRepository.save(examdb);
		
		//then
		Assertions.assertThat(updatedexam.getExamduration()).isEqualTo("60 mins");

	}
	
	@Test
	@DisplayName("Junit test for delete exam operation")
	public void givenexamObject_whenDeletedexam_thenDeletedexamNull()
	{
		//given
		//given
		 exam = ExamEntity.builder().examName("java ELAT")
				 					.examduration("2 hrs")
				 					.totalQuestions("100")
				 					.totalMarks("100")
								 .build();
		ExamEntity savedexam=examRepository.save(exam);
		
		//when
		ExamEntity examdb=this.examRepository.findById(exam.getExamId()).get();
		this.examRepository.delete(examdb);
		Optional<ExamEntity> examdb2=this.examRepository.findById(exam.getExamId());
		//then
		Assertions.assertThat(examdb2).isEmpty();
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenExamName_whenFindByJPQLIndex_thenReturnExamObject()
	{
		//Given
		exam = ExamEntity.builder().examName("java ELAT")
					.examduration("2 hrs")
					.totalQuestions("100")
					.totalMarks("100")
			 .build();
		ExamEntity saved=examRepository.save(exam);
		//When
		ExamEntity savedexam=examRepository.findByExamNameWithIndexParam(exam.getExamName());
		//Then
		Assertions.assertThat(savedexam).isNotNull();
		Assertions.assertThat(savedexam.getExamId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenExamName_whenFindByJPQLNamed_thenReturnExamObject()
	{
		//Given
		exam = ExamEntity.builder().examName("java ELAT")
				.examduration("2 hrs")
				.totalQuestions("100")
				.totalMarks("100")
		 .build();
		ExamEntity saved=examRepository.save(exam);
		//When
		ExamEntity savedexam=examRepository.findByExamNameWithNamedParam(exam.getExamName());
		//Then
		Assertions.assertThat(savedexam).isNotNull();
		Assertions.assertThat(savedexam.getExamId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenExamName_whenFindByJPQLNativeIndexed_thenReturnExamObject()
	{
		//Given
		exam = ExamEntity.builder().examName("java ELAT")
				.examduration("2 hrs")
				.totalQuestions("100")
				.totalMarks("100")
				.build();
		ExamEntity saved=examRepository.save(exam);
		//When
		ExamEntity savedexam=examRepository.findByExamNameWithNativeQueryIndexParam(exam.getExamName());
		//Then
		Assertions.assertThat(savedexam).isNotNull();
		Assertions.assertThat(savedexam.getExamId()).isGreaterThan(0);
	}
////	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenExamName_whenFindByJPQLNativeNamed_thenReturnExamObject()
	{
		//Given
		exam = ExamEntity.builder().examName("java ELAT")
				.examduration("2 hrs")
				.totalQuestions("100")
				.totalMarks("100")
				.build();
		ExamEntity saved=examRepository.save(exam);
		//When
		ExamEntity savedexam=examRepository.findByExamNameWithNativeQueryNamedParam(exam.getExamName());
		//Then
		Assertions.assertThat(savedexam).isNotNull();
		Assertions.assertThat(savedexam.getExamId()).isGreaterThan(0);}


}

