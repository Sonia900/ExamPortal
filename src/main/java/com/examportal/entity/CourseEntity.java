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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Table(name = "course")
public class CourseEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int courseId;
		
		@Column(nullable = false)
		@NotEmpty(message = "Course name cannot be empty")
		@Size(min=4,max=50,message="Course name must be min 4 characters and max 50 characters")
		private String courseName;
		
		@Column(nullable = false)
		@NotEmpty(message = "Course name cannot be empty")
		@Size(min=4,max=50,message="Course duration must be min 4 months")
		private String courseDuration;
		
		@Column(nullable = false)
		@NotEmpty(message = "Course fees cannot be empty")
		@Size(min=4,max=50,message="Course fees must be min 2000 Rupees")
		private String courseFees;
		
		@ManyToOne
		@JoinColumn(name = "student_id")
		private StudentEntity student;
		
		@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
		@JsonIgnore
		private List<SubjectEntity>  subjectList=new ArrayList();

}