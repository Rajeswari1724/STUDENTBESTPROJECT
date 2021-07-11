package com.te.student.beans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("stu_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)         // if we dont want to see json values as null then we will use this one
public class StudentResponce implements Serializable {

	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("stu_grade")
	private String grade;
	
	@JsonProperty("student_infoofGrade")                                 
	private StudentBean bean;
	
	public StudentBean getBean() {
		return bean;
	}

	public void setBean(StudentBean bean) {
		this.bean = bean;
	}

	@JsonProperty("stu_details")
	private List<StudentBean>  studentBeans;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<StudentBean> getStudentBeans() {
		return studentBeans;
	}

	public void setStudentBeans(List<StudentBean> studentBeans) {
		this.studentBeans = studentBeans;
	}
	
}
