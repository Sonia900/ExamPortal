package com.examportal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.entity.StudentEntity;
import com.examportal.exception.ApiResponse;
import com.examportal.payload.StudentDto;
import com.examportal.service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
//	@GetMapping("/")
//	public StudentEntity home()
//	{
//		StudentEntity student=new  StudentEntity();
//		student.setStudentId(1);
//		student.setStudentName("Alpha");
//		student.setStudentAge("23");
//		student.setStudentEmail("alpha@gmail.com");
//		student.setStudentGender("Male");
//		student.setStudentPassword("Alpha@123");
//		return student;
//	}
	@PostMapping("/")
	public StudentDto addStudent(@Valid @RequestBody StudentDto student)
	{
		return this.studentservice.addStudent(student);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>>  getallStudents()
	{
		List<StudentDto> getallStudents = this.studentservice.getallStudents();
		return new ResponseEntity<List<StudentDto>>(getallStudents,HttpStatus.OK);
	}
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable("studentId")int studentId)
	{
		this.studentservice.deleteStudentById(studentId);
		ApiResponse apiResponse=new ApiResponse("Student Record not found",true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
		
	}
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto student,@PathVariable("studentId") int studentId)
	{
		StudentDto updateStudent = this.studentservice.updateStudent(student, studentId);
		return new ResponseEntity<StudentDto>(updateStudent,HttpStatus.OK);
	}

}

