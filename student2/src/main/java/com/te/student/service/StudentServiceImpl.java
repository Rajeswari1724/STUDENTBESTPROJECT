package com.te.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.student.beans.StudentBean;
import com.te.student.dao.StudentDao;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public String getStudent(double marks) {

		return dao.getStudent(marks);
	}

	@Override
	public boolean deleteStuData(double marks) {

		return dao.deleteStuData(marks);
	}

	@Override
	public List<StudentBean> getAllStu() {

		return dao.getAllStu();
	}

	@Override
	public boolean addStudent(StudentBean bean) {

		return dao.addStudent(bean);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {

		return dao.updateStudent(bean);
	}

	@Override
	public StudentBean getDetailsBasedOnName(String name) {
		
		return dao.getDetailsBasedOnName(name);
	}

	@Override
	public String getGradeBasedOnName(String name) {

		return dao.getGradeBasedOnName(name);
	}

}

