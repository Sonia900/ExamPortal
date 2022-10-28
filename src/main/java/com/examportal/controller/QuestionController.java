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

import com.examportal.exception.ApiResponse;
import com.examportal.payload.QuestionDto;
import com.examportal.payload.StudentDto;
import com.examportal.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	// get question method
	@GetMapping("/ questionId")
 	public ResponseEntity<QuestionDto> getQuestionById(@PathVariable(" questionId") int  questionId)
 	{
		QuestionDto  question=this.questionService.getQuestionById( questionId);
		question.setQuestionId(1);
 		
 		return new ResponseEntity<QuestionDto>(question,HttpStatus.OK);		
 	}	

	@PostMapping("/")
	public QuestionDto addQuestion(@Valid @RequestBody QuestionDto questionDto) {
		return this.questionService.addQuestion(questionDto);
	}
	
	 // get All question method
    @GetMapping("/")
    public ResponseEntity<List<QuestionDto>> getAllQuestion()
    {
    	List<QuestionDto> getallQuestions=this.questionService.getAllquestion();
    	  return new ResponseEntity<List<QuestionDto>>(getallQuestions,HttpStatus.OK);
    
    }

 	 //deletequestionById
  	@DeleteMapping("/{questionId}")
  	public ResponseEntity<ApiResponse> deleteQuestionById(@PathVariable("questionId") int questionId)
  	{
  		this.questionService.deleteQuestionById(questionId);
  		ApiResponse response=new ApiResponse("Question record is deleted",true);
  		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
  	}
  	
   //questionCourse
  	@PutMapping("/{questionId}")
  	public ResponseEntity<QuestionDto> updateQuestion(@Valid @RequestBody QuestionDto question,
  												@PathVariable("questionId") int questionId)
  	{
  		QuestionDto updateQuestion=this.questionService.updateQuestion(question, questionId);
  		return new ResponseEntity<QuestionDto>(updateQuestion,HttpStatus.OK);
  		
  	}
}
