package com.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.entity.ExamEntity;

public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {
	
	//JPQL with index param
			@Query("select s from ExamEntity s where s.examName=?1")
			ExamEntity findByExamNameWithIndexParam(String subjectName);

//	//
				//JPQL with named param
				@Query("select s from ExamEntity s where s.examName=:examName")
				ExamEntity findByExamNameWithNamedParam(@Param("examName") String examName);
//////				
				//JPQL with native query with index param
				@Query(value="select * from Exam s where s.exam_Name=?1",nativeQuery = true)
				ExamEntity findByExamNameWithNativeQueryIndexParam(String examName);

				//JPQL with native query with named parqam
				@Query(value="select * from Exam s where s.exam_name=:examName",nativeQuery = true)
				ExamEntity findByExamNameWithNativeQueryNamedParam(@Param("examName") String examName);


}
