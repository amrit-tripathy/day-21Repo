package com.grayMatter.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Persistable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="project22Person")
public class Person  {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name="aadharnum")
	private long aadharnum;
	@Column(name="personName")
	@Size(min=3,message="person name must be more than 3 characters length")
	private String name;
	@NotNull
	@Pattern(regexp = "[6789][0-9]{9}",message="mobile number must be of 10 length starting with either 6,7,8,9")
	private String mobileNum;
	@Range(min=18,message="Age must be more than 18 to cast vote")
	private int age;
	@Email
	private String email;
	
	
	
	
	
	
}
