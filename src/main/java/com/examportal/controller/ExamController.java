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
import com.examportal.payload.CourseDto;
import com.examportal.payload.ExamDto;
import com.examportal.service.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController 
{
	@Autowired
	private ExamService examService;
	
	// get course method
	@GetMapping("/{examId}")
 	public ResponseEntity<ExamDto> getExamById(@PathVariable("examId") int  examId)
 	{
		ExamDto  exam=this.examService.getExamById( examId);
 		exam.setExamId(1);
 		exam.setExamName("Java");
 		exam.setExamduration("3 hr");
 		return new ResponseEntity<ExamDto>(exam,HttpStatus.OK);		
 	}
 	
	@PostMapping("/")
	public ExamDto addExam(@Valid @RequestBody ExamDto examDto) {
		return this.examService.addExam(examDto);
	}
	
	 // get All subject method
    @GetMapping("/")
    public ResponseEntity<List<ExamDto>> getAllExam()
    {
    	   List<ExamDto> allExam = this.examService.getAllExam();
    	   return new ResponseEntity<List<ExamDto>>(allExam,HttpStatus.OK);    
    }
    

 	 //deleteSubjectById
  	@DeleteMapping("/{examId}")
  	public ResponseEntity<ApiResponse> deleteExamById(@PathVariable("examId") int examId)
  	{
  		this.examService.deleteExamById(examId);
  		ApiResponse response=new ApiResponse("Exam record is deleted",true);
  		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
  	}
  	
   //updateCourse
  	@PutMapping("/{examId}")
  	public ResponseEntity<ExamDto> updateExam(@Valid @RequestBody ExamDto exam,
  												@PathVariable("examId") int examId)
  	{
  		ExamDto updateExam=this.examService.updateExam(exam, examId);
  		return new ResponseEntity<ExamDto>(updateExam,HttpStatus.OK);
  		
  	}
     
    
	

}
