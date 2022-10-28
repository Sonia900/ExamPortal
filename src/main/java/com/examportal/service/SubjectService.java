package com.examportal.service;

import java.util.List;

import com.examportal.payload.SubjectDto;

	
public interface SubjectService {
		public SubjectDto addSubject(SubjectDto subject);
		
		public List<SubjectDto> getAllsubject();
		
		public SubjectDto getSubjectById(int subjectId);
		
		public void deleteSubjectById(int subjectId);

		public  SubjectDto updateSubject(SubjectDto course, int subjectId);
		
		public List<SubjectDto> getSubjectsByCourseId();



	}
