package com.examportal.service;

import java.util.List;

import com.examportal.payload.ExamDto;

public interface ExamService 
{
	public ExamDto addExam( ExamDto exam);
	
	public  ExamDto getExamById(int  examId);
	
	public void deleteExamById(int  examId);
	
	public  ExamDto updateExam(ExamDto exam, int  examId);
	
	public List<ExamDto> getExamBySubjectId();

	public List<ExamDto> getAllExam();

}


