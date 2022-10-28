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
import com.examportal.payload.StudentDto;
import com.examportal.payload.SubjectDto;
import com.examportal.service.SubjectService;



@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;

	@PostMapping("/")
	public SubjectDto addSubject(@Valid @RequestBody SubjectDto subject) {
		return this.subjectService.addSubject(subject);

}
	 // get All subject method
    @GetMapping("/")
    public ResponseEntity<List<SubjectDto>> getAllsubject()
    {
    	List<SubjectDto> getallSubject=this.subjectService.getAllsubject();
    	  return new ResponseEntity<List<SubjectDto>>(getallSubject,HttpStatus.OK);
    
    }
    	//get all subject id
        @GetMapping("/{subjectId}") // mapping handler
        public ResponseEntity<SubjectDto> getSubjectById(@PathVariable("subjectId") int subjectId)
        {
        	SubjectDto subject=this.subjectService.getSubjectById(subjectId);
    		
        	return new ResponseEntity<SubjectDto>(subject,HttpStatus.OK);
        	
        }
      //deleteSubjectById
      	@DeleteMapping("/{subjectId}")
      	public ResponseEntity<ApiResponse> deleteSubjectById(@PathVariable("subjectId") int subjectId)
      	{
      		this.subjectService.deleteSubjectById(subjectId);
      		ApiResponse response=new ApiResponse("Subject record is deleted",true);
      		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
      	}
      //updateCourse
      	@PutMapping("/{subjectId}")
      	public ResponseEntity<SubjectDto> updateSubject(@Valid @RequestBody SubjectDto subject,
      												@PathVariable("subjectId") int subjectId)
      	{
      		SubjectDto updateSubject=this.subjectService.updateSubject(subject, subjectId);
      		return new ResponseEntity<SubjectDto>(updateSubject,HttpStatus.OK);
      		
      	}
    
}