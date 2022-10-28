package com.examportal.payload;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.StudentEntity;
import com.examportal.entity.SubjectEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class CourseDto
{
private int courseId;
	
	private String courseName;
	
	private String courseDuration;
	
	private String courseFees;
	//@JsonBackReference
	
	private StudentDto student;
	
	@JsonIgnore
	private List<SubjectDto>  subjectList=new ArrayList();

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public List<SubjectDto> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectDto> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public String toString() {
		return "CourseDto [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", courseFees=" + courseFees + ", student=" + student + ", subjectList=" + subjectList + "]";
	}

	public CourseDto(int courseId, String courseName, String courseDuration, String courseFees, StudentDto student,
			List<SubjectDto> subjectList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseFees = courseFees;
		this.student = student;
		this.subjectList = subjectList;
	}

	public CourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}