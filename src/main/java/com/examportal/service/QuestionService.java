package com.examportal.service;

import java.util.List;

import com.examportal.payload.QuestionDto;

public interface QuestionService {
	
public QuestionDto addQuestion(QuestionDto question);
	
	public QuestionDto getQuestionById(int questionId);
	
	public void deleteQuestionById(int questionId);
	
	public QuestionDto updateQuestion(QuestionDto question, int questionId);
	
	public List<QuestionDto> getQuestionsByExamId();

	public List<QuestionDto> getAllquestion();

}
