package com.examportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.StudentEntity;
import com.examportal.exception.ResourceNotFoundException;
import com.examportal.payload.CourseDto;
import com.examportal.payload.StudentDto;
import com.examportal.repository.StudentRepository;
import com.examportal.service.StudentService;



@Service
public class StudentServiceImplementation implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		StudentEntity studentEntity=this.modelMapper.map(studentDto,StudentEntity.class);
		StudentEntity savedStudent=this.studentRepository.save(studentEntity);
		return this.modelMapper.map(savedStudent, StudentDto.class);

	}

	@Override
	public List<StudentDto> getallStudents() 
	{
		List<StudentEntity> studentlist=this.studentRepository.findAll();
		List<StudentDto> studentDtolist=studentlist.stream().map((student)->
		this.modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
		return studentDtolist;
	}

	@Override
	public void deleteStudentById(int studentId) {
		
		this.studentRepository.findById(studentId).orElseThrow(()-> new com.examportal.exception.ResourceNotFoundException("Student","StudentID",studentId));
		this.studentRepository.deleteById(studentId);
//		this.studentRepository.findById(studentId).orElseThrow(()->
//		new ResourceNotFoundException("student", "student id", studentId));
//		this.studentRepository.deleteById(studentId);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, int studentId) 
	{
		// TODO Auto-generated method stub
		StudentEntity studentobj=this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("student", "student id", studentId));
		
		studentDto.setStudentId(studentId);
		StudentEntity updatestudent=this.modelMapper.map(studentDto, StudentEntity.class);
		StudentEntity entity= this.studentRepository.save(updatestudent);
		return this.modelMapper.map(entity, StudentDto.class);
	}

	@Override
	public List<StudentDto> getStudentByCourse(CourseDto course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
