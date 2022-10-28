package com.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.entity.ExamEntity;
import com.examportal.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer>
{

	//JPQL with index param
	@Query("select s from QuestionEntity s where s.question=?1")
	QuestionEntity findByQuestionWithIndexParam(String question);


		//JPQL with named param
		@Query("select s from QuestionEntity s where s.question=:question")
		QuestionEntity findByQuestionWithNamedParam(@Param("question") String question);
		
		//JPQL with native query with index param
		@Query(value="select * from Question s where s.question_Name=?1",nativeQuery = true)
		QuestionEntity findByQuestionNameWithNativeQueryIndexParam(String questionName);

		//JPQL with native query with named parqam
		@Query(value="select * from Question s where s.question_name=:questionName",nativeQuery = true)
		QuestionEntity findByQuestionNameWithNativeQueryNamedParam(@Param("questionName") String questionName);


}
