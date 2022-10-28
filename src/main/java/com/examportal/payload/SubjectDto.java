package com.examportal.payload;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.ExamEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SubjectDto 
{
	private int subjectId;
	
	private String subjectName;
	
	private String subjectDescription;

	//@JsonManagedReference
	//@JsonIgnore
	private CourseDto course;
	
	@JsonIgnore
	private List<ExamDto>  examList=new ArrayList();

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public CourseDto getCourse() {
		return course;
	}

	public void setCourse(CourseDto course) {
		this.course = course;
	}

	public List<ExamDto> getExamList() {
		return examList;
	}

	public void setExamList(List<ExamDto> examList) {
		this.examList = examList;
	}

	@Override
	public String toString() {
		return "SubjectDto [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectDescription="
				+ subjectDescription + ", course=" + course + ", examList=" + examList + "]";
	}

	public SubjectDto(int subjectId, String subjectName, String subjectDescription, CourseDto course,
			List<ExamDto> examList) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectDescription = subjectDescription;
		this.course = course;
		this.examList = examList;
	}

	public SubjectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
