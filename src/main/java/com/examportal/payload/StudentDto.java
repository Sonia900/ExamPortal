package com.examportal.payload;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.ExamEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentDto 
{
	
	private int studentId;
	
	private String studentName;
	
	private int studentAge;
	
	private String studentEmail;
	
	private String studentGender;
	
	private String studentPassword;
	
	@JsonIgnore
	private List<CourseDto> courselist=new ArrayList();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public List<CourseDto> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<CourseDto> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentEmail=" + studentEmail + ", studentGender=" + studentGender + ", studentPassword="
				+ studentPassword + ", courselist=" + courselist + "]";
	}

	public StudentDto(int studentId, String studentName, int studentAge, String studentEmail, String studentGender,
			String studentPassword, List<CourseDto> courselist) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentEmail = studentEmail;
		this.studentGender = studentGender;
		this.studentPassword = studentPassword;
		this.courselist = courselist;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
