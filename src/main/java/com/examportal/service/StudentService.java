package com.examportal.service;

import java.util.List;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.StudentEntity;
import com.examportal.payload.CourseDto;
import com.examportal.payload.StudentDto;

public interface StudentService {
	
public StudentDto addStudent(StudentDto student);
	
	public List<StudentDto> getallStudents();
	
	public StudentDto getStudentById(int studentId);
	
	public void deleteStudentById(int studentId);
	
	public StudentDto updateStudent(StudentDto student,int studentId);
	
	public  List<StudentDto> getStudentByCourse(CourseDto course);

}
