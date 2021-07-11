package com.te.student.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


import lombok.Data;

@Data
@Entity
@Table(name = "student2")
@JsonRootName("student-info")
@JsonPropertyOrder({ "id", "name" })
public class StudentBean implements Serializable {

	
	@Column
	@JsonProperty("stu_id")
	private Integer id;

	@Column
	private String name;
    
	@Id
	@Column
	private Double marks;
	
	@Column
	private String email;
	
	@Column
	private String grade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
 
}
