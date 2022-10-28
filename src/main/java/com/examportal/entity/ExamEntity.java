package com.examportal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exam")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;

	@Column(nullable = false)
	@NotEmpty(message = "Exam name cannot be empty")
	@Size(min=4,max=50,message="Exam name must be min 4 characters and max 50 characters")
	private String examName;
	
	@Column(nullable = false)
	@NotEmpty(message = "Exam duration cannot be empty")
	@Size(min=1,max=60,message="Exam duration must be min 1 minutes and max 60 Hours")
	private String examduration;
	
	@Column(nullable = false)
	@NotEmpty(message = "Total question cannot be empty")
	@Size(min=1,max=100,message="Minimum question must be 1 and maximum question must be 100")
	private String totalQuestions;
	
	@Column(nullable = false)
	@NotEmpty(message = "Marks cannot be empty")
	@Size(min=0,max=50,message="Marks must be min 0 and max 100")
	private String totalMarks;
	
	@ManyToOne
	@JoinColumn(name="subject_Id")
	private SubjectEntity subject;
	
	@OneToMany(mappedBy = "exam",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<QuestionEntity>  questionList=new ArrayList();
	
}