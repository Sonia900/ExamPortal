package com.examportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "question")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	
	@Column(nullable = false)
	@NotEmpty(message = "Question field cannot be empty")
	@Size(min=1,max=50,message="please enter Question")
	private String question;
	
	@Column(nullable = false)
	@NotEmpty(message = "Correct answer field cannot be empty")
	@Size(min=1,max=50,message="please enter correct answer")
	private String correctAnswer;
	
	@Column(nullable = false)
	@NotEmpty(message = "Option A cannot be empty")
	@Size(min=1,max=50,message="please enter option A")
	private String optionA;
	
	@Column(nullable = false)
	@NotEmpty(message = "Option B cannot be empty")
	@Size(min=1,max=50,message="please enter option B")
	private String optionB;
	
	@Column(nullable = false)
	@NotEmpty(message = "Option C cannot be empty")
	@Size(min=1,max=50,message="please enter option C")
	private String optionC;
	
	@Column(nullable = false)
	@NotEmpty(message = "Option D cannot be empty")
	@Size(min=1,max=50,message="please enter option D")
	private String optionD;
	
	@ManyToOne
	@JoinColumn(name="exam_Id1")
	private ExamEntity exam;
	
}