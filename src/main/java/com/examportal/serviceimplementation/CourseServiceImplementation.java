package com.examportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.CourseEntity;
import com.examportal.exception.ResourceNotFoundException;
import com.examportal.payload.CourseDto;
import com.examportal.repository.CourseRepository;
import com.examportal.service.CourseService;


@Service
public class CourseServiceImplementation implements CourseService 
{
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		CourseEntity courseEntity = this.modelMapper.map(courseDto,CourseEntity.class);
		CourseEntity savedCourse=this.courseRepository.save(courseEntity);
		return this.modelMapper.map(savedCourse, CourseDto.class);
	}
	
	

	@Override
	public List<CourseDto> getAllCourse() {
		List<CourseEntity> courselist=this.courseRepository.findAll();
		List<CourseDto> courseDtolist=courselist.stream().map((course)->this.modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
		return courseDtolist;
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		CourseEntity courseEntity=this.courseRepository.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("course", "course id", courseId));
		
		
		return this.modelMapper.map(courseEntity, CourseDto.class);
	}

	@Override
	public void deleteCourseById(int courseId) {
		this.courseRepository.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("course", "course id", courseId));
		 this.courseRepository.deleteById(courseId);
	}

	@Override
	public CourseDto updateCourse(CourseDto coursedto, int courseId) {
		CourseEntity courseEntity=this.courseRepository.findById(courseId).orElseThrow(()->
		new ResourceNotFoundException("course", "course id", courseId));
		
		coursedto.setCourseId(courseId);
		CourseEntity updatecourse=this.modelMapper.map(coursedto,CourseEntity.class);
		CourseEntity entity=this.courseRepository.save(updatecourse);
		return this.modelMapper.map(entity, CourseDto.class);
	}

	@Override
	public List<CourseDto> getEnrolledCourseByStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}


}

