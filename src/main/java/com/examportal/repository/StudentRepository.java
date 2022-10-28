package com.examportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examportal.entity.StudentEntity;

public interface StudentRepository extends JpaRepository <StudentEntity,Integer>
{
	//JPQL with index param
	@Query("select s from StudentEntity s where s.studentName=?1 and s.studentEmail=?2")
	StudentEntity findByStudentNameAndstudentEmailWithIndexParam(String studentName,String studentEmail);

	//JPQL with named param
	@Query("select s from StudentEntity s where s.studentName=:studentName and s.studentEmail=:studentEmail")
	StudentEntity findByStudentNameAndstudentEmailWithNamedParam(@Param("studentName") String studentName,@Param("studentEmail") String studentEmail);
	
	//JPQL with native query with index param
	@Query(value="select * from student s where s.student_Name=?1 and s.student_Email=?2",nativeQuery = true)
	StudentEntity findByStudentNameAndstudentEmailWithNativeQueryIndexParam(String studentName,String studentEmail);

	//JPQL with native query with named parqam
	@Query(value="select * from student s where s.student_name=:studentName and s.student_Email=:studentEmail",nativeQuery = true)
	StudentEntity findByStudentNameAndstudentEmailWithNativeQueryNamedParam(@Param("studentName") String studentName,@Param("studentEmail") String studentEmail);
	

}
