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
import com.examportal.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/")
	public CourseDto addCourse(@Valid @RequestBody CourseDto course)
	{
		
		return this.courseService.addCourse(course);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CourseDto>>  getAllCourse()
	{
		List<CourseDto> course= this.courseService.getAllCourse();
		return new ResponseEntity<List<CourseDto>>(course,HttpStatus.OK);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("courseId") int courseId)
	{
		CourseDto courseDto=this.courseService.getCourseById(courseId);
		return new ResponseEntity<CourseDto>(courseDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<ApiResponse> deleteCourseById(@PathVariable("courseId")int courseId)
	{
		this.courseService.deleteCourseById(courseId);
		ApiResponse apiResponse=new ApiResponse("Course Record not found",true);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);
		
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<CourseDto> updateCourse(@Valid @RequestBody CourseDto course,@PathVariable("courseId") int courseId)
	{
		CourseDto updatecourse = this.courseService.updateCourse(course, courseId);
		return new ResponseEntity<CourseDto>(updatecourse,HttpStatus.OK);
	}
}
