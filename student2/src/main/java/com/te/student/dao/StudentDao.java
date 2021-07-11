package com.te.student.dao;

import java.util.List;

import com.te.student.beans.StudentBean;

public interface StudentDao {

	public String getStudent(double marks);

	public boolean deleteStuData(double marks);

	public List<StudentBean> getAllStu();
	
	public StudentBean getDetailsBasedOnName(String name);
	
	public String getGradeBasedOnName(String name);

	public boolean addStudent(StudentBean bean);

	public boolean updateStudent(StudentBean bean);
}