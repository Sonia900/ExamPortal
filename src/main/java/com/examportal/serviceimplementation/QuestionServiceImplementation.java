package com.examportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.QuestionEntity;
import com.examportal.exception.ResourceNotFoundException;
import com.examportal.payload.CourseDto;
import com.examportal.payload.QuestionDto;
import com.examportal.repository.QuestionRepository;
import com.examportal.service.CourseService;
import com.examportal.service.QuestionService;

@Service
public class QuestionServiceImplementation implements QuestionService
{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public QuestionDto addQuestion(QuestionDto question) {
		QuestionEntity questionEntity=this.modelMapper.map(question, QuestionEntity.class);
		QuestionEntity savedQuestion=this.questionRepository.save(questionEntity);
		return this.modelMapper.map(savedQuestion,QuestionDto.class );
	}

	@Override
	public QuestionDto getQuestionById(int questionId) {
		QuestionEntity question=this.questionRepository.findById(questionId).orElseThrow(() ->
		new ResourceNotFoundException("question","question Id",questionId));
		return this.modelMapper.map(question, QuestionDto.class);
	
	}

	@Override
	public void deleteQuestionById(int questionId) {
		this.questionRepository.findById(questionId).orElseThrow(()->
		new ResourceNotFoundException("question","question Id", questionId));
		this.questionRepository.deleteById(questionId);
	}

	@Override
	public QuestionDto updateQuestion(QuestionDto question, int questionId) {
		 QuestionEntity  questionobj= this. questionRepository.findById( questionId).orElseThrow(() ->
		 new ResourceNotFoundException(" question"," question Id", questionId));
		 QuestionEntity updatedQuestionObj=this.modelMapper.map( question,  QuestionEntity.class);
		 
		 
		 QuestionEntity updatedQuestion = this.questionRepository.save(updatedQuestionObj);
		 return this.modelMapper.map( updatedQuestion, QuestionDto.class);
	}

	@Override
	public List<QuestionDto> getQuestionsByExamId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionDto> getAllquestion() {
		List<QuestionEntity> questionList=this.questionRepository.findAll();
		List<QuestionDto> QuestionDtoList=questionList.stream().map((question)-> 
		this.modelMapper.map(question,QuestionDto.class)).collect(Collectors.toList());
		return QuestionDtoList;

	}

	
}
