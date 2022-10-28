package com.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.SubjectEntity;


public interface SubjectRepository extends JpaRepository<SubjectEntity,Integer>{
	
	//JPQL with index param
		@Query("select s from SubjectEntity s where s.subjectName=?1")
		SubjectEntity findBySubjectNameWithIndexParam(String subjectName);

//
			//JPQL with named param
			@Query("select s from SubjectEntity s where s.subjectName=:subjectName")
			SubjectEntity findBySubjectNameWithNamedParam(@Param("subjectName") String subjectName);
////			
			//JPQL with native query with index param
			@Query(value="select * from Subject s where s.subject_Name=?1",nativeQuery = true)
			SubjectEntity findBySubjectNameWithNativeQueryIndexParam(String subjectName);

			//JPQL with native query with named parqam
			@Query(value="select * from Subject s where s.subject_name=:subjectName",nativeQuery = true)
			SubjectEntity findBySubjectNameWithNativeQueryNamedParam(@Param("subjectName") String subjectName);

}

