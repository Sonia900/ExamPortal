package com.examportal.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.CourseEntity;
import com.examportal.entity.ExamEntity;
import com.examportal.exception.ResourceNotFoundException;
import com.examportal.payload.CourseDto;
import com.examportal.payload.ExamDto;
import com.examportal.repository.ExamRepository;
import com.examportal.service.ExamService;

@Service
public class ExamServiceImplementation implements ExamService 
{
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ExamDto addExam(ExamDto exam) {
		ExamEntity examEntity=this.modelMapper.map(exam, ExamEntity.class);
		ExamEntity savedExam=this.examRepository.save(examEntity);
		return this.modelMapper.map(savedExam,ExamDto.class );
	}

	@Override
	public ExamDto getExamById(int examId) {
		ExamEntity exam=this.examRepository.findById(examId).orElseThrow(() ->
		new ResourceNotFoundException("exam","examId",examId));
		System.out.println(exam);
		System.out.println(this.modelMapper.map(exam, ExamDto.class));
		return this.modelMapper.map(exam, ExamDto.class);
	
	}

	@Override
	public void deleteExamById(int examId) {
		this.examRepository.findById(examId).orElseThrow(()->
		new ResourceNotFoundException("exam","exam Id", examId));
		this.examRepository.deleteById(examId);
	}

	@Override
	public ExamDto updateExam(ExamDto exam, int examId) {
		 ExamEntity  examobj= this. examRepository.findById( examId).orElseThrow(() ->
		new ResourceNotFoundException(" exam"," exam Id", examId));
		 ExamEntity updatedExam=this.modelMapper.map( exam,  ExamEntity.class);
		return this.modelMapper.map( examobj, ExamDto.class);
	}

	@Override
	public List<ExamDto> getExamBySubjectId() {
		return null;
	}

	@Override
	public List<ExamDto> getAllExam() {
		List<ExamEntity> examList=this.examRepository.findAll();
		System.out.println("*********************************************************"+examList);
		List<ExamDto> ExamDtoList=examList.stream().map((exam)->this.modelMapper.map(exam,ExamDto.class)).collect(Collectors.toList());
		return ExamDtoList;

	}
	
}

