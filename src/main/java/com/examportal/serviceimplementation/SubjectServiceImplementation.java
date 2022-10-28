package com.examportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.SubjectEntity;
import com.examportal.exception.ResourceNotFoundException;
import com.examportal.payload.CourseDto;
import com.examportal.payload.SubjectDto;
import com.examportal.repository.SubjectRepository;
import com.examportal.service.SubjectService;

@Service
public class SubjectServiceImplementation implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public SubjectDto addSubject(SubjectDto subjectDto) {
		// TODO Auto-generated method stub
		
		//System.out.println("Student Dto    "+subjectDto);
		SubjectEntity subjectEntity=this.modelMapper.map(subjectDto, SubjectEntity.class);
		
		//System.out.println("Student Entity    "+subjectEntity);
		SubjectEntity savedSubject=this.subjectRepository.save(subjectEntity);
		
		return this.modelMapper.map(savedSubject,SubjectDto.class );
	}

	@Override
	public List<SubjectDto> getAllsubject() {
			List<SubjectEntity> subjectList=this.subjectRepository.findAll();
			List<SubjectDto> SubjectDtoList=subjectList.stream().map((subject)->
					this.modelMapper.map(subject,SubjectDto.class)).collect(Collectors.toList());		
			// TODO Auto-generated method stub
			return SubjectDtoList;
	}

	@Override
	public SubjectDto getSubjectById(int subjectId) {
			// TODO Auto-generated method stub
			SubjectEntity subject=this.subjectRepository.findById(subjectId).orElseThrow(() ->
			new ResourceNotFoundException("subject","subject Id",subjectId));
			return this.modelMapper.map(subject, SubjectDto.class);
		
	}

	@Override
	public void deleteSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		this.subjectRepository.findById(subjectId).orElseThrow(()->
		new ResourceNotFoundException("subject","subject id", subjectId));
		this.subjectRepository.deleteById(subjectId);
		
		
	}

	@Override
	public SubjectDto updateSubject(SubjectDto subject, int subjectId) {
		// TODO Auto-generated method stub
			SubjectEntity subjectobj= this.subjectRepository.findById(subjectId).orElseThrow(() ->
				new ResourceNotFoundException("Subject","Subject Id",subjectId));
				subject.setSubjectId(subjectId);
				SubjectEntity updatedSubject=this.modelMapper.map(subject, SubjectEntity.class);
				SubjectEntity entity=this.subjectRepository.save(updatedSubject);
				return this.modelMapper.map(entity,SubjectDto.class);
				
				/*StudentEntity studentobj=this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("student", "student id", studentId));
		
		
		studentDto.setStudentId(studentId);
		StudentEntity updatestudent=this.modelMapper.map(studentDto, StudentEntity.class);
		StudentEntity entity= this.studentRepository.save(updatestudent);
		return this.modelMapper.map(entity, StudentDto.class);*/
	
	}

	@Override
	public List<SubjectDto> getSubjectsByCourseId() {
		// TODO Auto-generated method stub
		return null;
	}
	

}