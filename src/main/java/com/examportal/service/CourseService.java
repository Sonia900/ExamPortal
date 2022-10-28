package com.examportal.service;

import java.util.List;

import com.examportal.payload.CourseDto;


public interface CourseService
{
public CourseDto addCourse(CourseDto courseDto);
	
	public List<CourseDto> getAllCourse();
	
	public CourseDto getCourseById(int courseId);
	
	public void deleteCourseById(int courseId);
	
	public CourseDto updateCourse(CourseDto coursedto,int courseId);
	
	public  List<CourseDto> getEnrolledCourseByStudent(int studentId);
}
