package com.examportal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@Table(name = "student")
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class StudentEntity 
{

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int studentId;
		
		@Column(nullable = false)
		@NotEmpty(message = "Student name cannot be empty")
		@Size(min=4,max=50,message="Student name must be min 4 characters and max 50 characters")
		private String studentName;
		
		@Column(nullable = false)
		@NotNull(message = "Student age cannot be empty")
		@Min(value=18,message="Student age must be min 18 years old")
		@Max(value=30,message="Student age must be below 30 years old")
		private int studentAge;
		
		@Column(nullable = false)
		@Email
		private String studentEmail;
		
		@Column(nullable = false)
		@NotEmpty(message = "Student gender cannot be empty")
		@Size(min=4,max=6,message="Student gender must be either male or Female")
		private String studentGender;
		
		@Column(nullable = false)
		@NotEmpty(message = "Student name cannot be empty")
		@Size(min=8,max=50,message="Student password must be min 8 characters and max 50 characters")
		private String studentPassword;
		
		
		@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
		@JsonIgnore
		private List<CourseEntity> courselist=new ArrayList();


		
}
