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
import lombok.ToString;



@Entity
@Table(name = "subject")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	
	@Column(nullable = false)
	@NotEmpty(message = "Subject name cannot be empty")
	@Size(min=4,max=50,message="Subject name must be min 4 characters and max 50 characters")
	private String subjectName;
	
	@Column(nullable = false)
	@NotEmpty(message = "Subject description cannot be empty")
	@Size(min=4,max=100,message="Subject description must be min 12 characters and max 100 characters")
	private String subjectDescription;

	@ManyToOne
	@JoinColumn(name="course_Id")
	private CourseEntity course;
	
	
	@OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ExamEntity>  examList=new ArrayList();
	
}