package com.examportal.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.examportal.entity.ExamEntity;
import com.examportal.entity.QuestionEntity;

@DataJpaTest
public class QuestionRepositoryTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private QuestionEntity question;
	
	@Test
	@DisplayName("Junit test for save question operation")
	public void given_when_then()
	{
		//given
		 question = QuestionEntity.builder().question("what si java")
				 							.correctAnswer("programming language")
				 							.optionA("coffe")
				 							.optionB("programming language")
				 							.optionC("name")
				 							.optionD("none")
				 							.build();
		
		//when
		 QuestionEntity savedquestion = questionRepository.save(question);
		
		//then
		Assertions.assertThat(savedquestion).isNotNull();
		Assertions.assertThat(savedquestion.getQuestionId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Junit test for get question by Id operation")
	public void givenquestionObject_whenFindById_thenReturnedquestionObject()
	{
		//given
		question = QuestionEntity.builder().question("what si java")
					.correctAnswer("programming language")
					.optionA("coffe")
					.optionB("programming language")
					.optionC("name")
					.optionD("none")
					.build();

		
		//when
		QuestionEntity savedquestion = questionRepository.save(question);
		QuestionEntity questionById=this.questionRepository.findById(savedquestion.getQuestionId()).get();
		
		//then
		Assertions.assertThat(questionById).isNotNull();
		Assertions.assertThat(questionById.getQuestionId()).isGreaterThan(0);
		Assertions.assertThat(questionById.getQuestionId()).isEqualTo(savedquestion.getQuestionId());
	}
	
	@Test
	@DisplayName("Junit test for get all questions operation")
	public void givenquestionList_whenFindAllquestionsList_then()
	{
		//given
		question = QuestionEntity.builder().question("what si java")
					.correctAnswer("programming language")
					.optionA("coffe")
					.optionB("programming language")
					.optionC("name")
					.optionD("none")
					.build();

		//given
		QuestionEntity question1 = QuestionEntity.builder().question("what si java")
					.correctAnswer("programming language")
					.optionA("coffe")
					.optionB("programming language")
					.optionC("name")
					.optionD("none")
					.build();
				questionRepository.save(question);
				questionRepository.save(question1);
		
		//when
		List<QuestionEntity> questionList=this.questionRepository.findAll();
		//then
		Assertions.assertThat(questionList.size()).isNotNull();
		Assertions.assertThat(questionList.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("Junit test for update question operation")
	public void givenquestionObject_whenUpdatedquestion_thenReturnedUpdatedquestion()
	{
		
		//given
		question = QuestionEntity.builder().question("what si java")
					.correctAnswer("programming language")
					.optionA("coffe")
					.optionB("programming language")
					.optionC("name")
					.optionD("none")
					.build();

		QuestionEntity savedquestion=this.questionRepository.save(question);
		
		//when
		QuestionEntity questiondb=this.questionRepository.findById(question.getQuestionId()).get();
		questiondb.setQuestion("what is java");
		QuestionEntity updatedquestion=questionRepository.save(questiondb);
		
		//then
		Assertions.assertThat(updatedquestion.getQuestion()).isEqualTo("what is java");

	}
	
	@Test
	@DisplayName("Junit test for delete question operation")
	public void givenquestionObject_whenDeletedquestion_thenDeletedquestionNull()
	{
		//given
		question = QuestionEntity.builder().question("what si java")
				.correctAnswer("programming language")
				.optionA("coffe")
				.optionB("programming language")
				.optionC("name")
				.optionD("none")
				.build();
		QuestionEntity savedquestion=questionRepository.save(question);
		
		//when
		QuestionEntity questiondb=this.questionRepository.findById(question.getQuestionId()).get();
		this.questionRepository.delete(questiondb);
		Optional<QuestionEntity> questiondb2=this.questionRepository.findById(question.getQuestionId());
		//then
		Assertions.assertThat(questiondb2).isEmpty();
	}
	@Test
	@DisplayName("JUNIT test for JPQL Indexed Pram")
	public void givenQuestionName_whenFindByJPQLIndex_thenReturnQuestionObject()
	{
		//Given
		question = QuestionEntity.builder().question("what si java")
				.correctAnswer("programming language")
				.optionA("coffe")
				.optionB("programming language")
				.optionC("name")
				.optionD("none")
				.build();
		QuestionEntity saved=questionRepository.save(question);
		//When
		QuestionEntity savedquestion=questionRepository.findByQuestionWithIndexParam(question.getQuestion());
		//Then
		Assertions.assertThat(savedquestion).isNotNull();
		Assertions.assertThat(savedquestion.getQuestionId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL Named Pram")
	public void givenQuestionName_whenFindByJPQLNamed_thenReturnQuestionObject()
	{
		//Given
		question = QuestionEntity.builder().question("what si java")
				.correctAnswer("programming language")
				.optionA("coffe")
				.optionB("programming language")
				.optionC("name")
				.optionD("none")
				.build();
		QuestionEntity saved=questionRepository.save(question);
		//When
		QuestionEntity savedquestion=questionRepository.findByQuestionWithNamedParam(question.getQuestion());
		//Then
		Assertions.assertThat(savedquestion).isNotNull();
		Assertions.assertThat(savedquestion.getQuestionId()).isGreaterThan(0);
	}
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Indexed Pram")
	public void givenQuestionName_whenFindByJPQLNativeIndexed_thenReturnQuestionObject()
	{
		//Given
		question = QuestionEntity.builder().question("what si java")
				.correctAnswer("programming language")
				.optionA("coffe")
				.optionB("programming language")
				.optionC("name")
				.optionD("none")
				.build();
		QuestionEntity saved=questionRepository.save(question);
		//When
		QuestionEntity savedquestion=questionRepository.findByQuestionWithNamedParam(question.getQuestion());
		//Then
		Assertions.assertThat(savedquestion).isNotNull();
		Assertions.assertThat(savedquestion.getQuestionId()).isGreaterThan(0);
	}
	
	@Test
	@DisplayName("JUNIT test for JPQL NativeSQL Named Pram")
	public void givenQuestionName_whenFindByJPQLNativeNamed_thenReturnQuestionObject()
	{
		//Given
		question = QuestionEntity.builder().question("what si java")
				.correctAnswer("programming language")
				.optionA("coffe")
				.optionB("programming language")
				.optionC("name")
				.optionD("none")
				.build();
		QuestionEntity saved=questionRepository.save(question);
		//When
		QuestionEntity savedquestion=questionRepository.findByQuestionWithNamedParam(question.getQuestion());
		//Then
		Assertions.assertThat(savedquestion).isNotNull();
		Assertions.assertThat(savedquestion.getQuestionId()).isGreaterThan(0);}


}

