package com.examportal.payload;

import java.util.ArrayList;
import java.util.List;

import com.examportal.entity.QuestionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class ExamDto 
{
	private int examId;

	private String examName;
	
	private String examduration;
	
	private String totalQuestions;

	private String totalMarks;
	
	private SubjectDto subject;
	
	@JsonIgnore
	private List<QuestionDto>  questionList=new ArrayList();

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamduration() {
		return examduration;
	}

	public void setExamduration(String examduration) {
		this.examduration = examduration;
	}

	public String getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public SubjectDto getSubject() {
		return subject;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}

	public List<QuestionDto> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionDto> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "ExamDto [examId=" + examId + ", examName=" + examName + ", examduration=" + examduration
				+ ", totalQuestions=" + totalQuestions + ", totalMarks=" + totalMarks + ", subject=" + subject
				+ ", questionList=" + questionList + "]";
	}

	public ExamDto(int examId, String examName, String examduration, String totalQuestions, String totalMarks,
			SubjectDto subject, List<QuestionDto> questionList) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.examduration = examduration;
		this.totalQuestions = totalQuestions;
		this.totalMarks = totalMarks;
		this.subject = subject;
		this.questionList = questionList;
	}

	public ExamDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}