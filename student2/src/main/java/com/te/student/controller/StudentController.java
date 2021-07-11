package com.te.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.student.beans.StudentBean;
import com.te.student.beans.StudentResponce;
import com.te.student.service.StudentService;

@RestController
@CrossOrigin("http://localhost:4200")
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getAll() {
		StudentResponce response = new StudentResponce();
		List<StudentBean> studentBeans = service.getAllStu();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setStudentBeans(studentBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getStudent( double marks) {
		String gradeBeansresults = service.getStudent(marks);
		StudentResponce response = new StudentResponce();
		if (gradeBeansresults != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data found for marks : " + marks);
         	response.setGrade(gradeBeansresults);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Error Data Not found");
		}
		return response;
	}// end of getEmp
	
	@GetMapping(path = "/gettingGradeBasedOnName", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce gettingGradeBasedOnName(String name) {
		String gradeBeansresults = service.getGradeBasedOnName(name);
		StudentResponce response = new StudentResponce();
		if (gradeBeansresults != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data found for marks : " + name);
         	response.setGrade(gradeBeansresults);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Error Data Not found");
		}
		return response;
	}// end of getEmp
	
	@GetMapping(path = "/gettingDetailsBasedOnName", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce gettingDetailsBasedOnName(String name) {
		StudentBean beansresult = service.getDetailsBasedOnName(name);
		StudentResponce response = new StudentResponce();
		if (beansresult != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data found for name : " + name);
         	response.setBean(beansresult);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Error Data Not found");
		}
		return response;
	}// end of getEmp
	
	

	@DeleteMapping(path = "/delete/{marks}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponce deleteStu(@PathVariable(name = "marks") double marks) {
		StudentResponce response = new StudentResponce();
		if (service.deleteStuData(marks)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data Deleted for marks : " + marks);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription(" Data Not for marks : " + marks);
		}

		return response;
	}//

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce addStu(@RequestBody StudentBean bean) {
		StudentResponce response = new StudentResponce();
		if (service.addStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce updateStu(@RequestBody StudentBean bean) {
		System.out.println(bean);
		StudentResponce response = new StudentResponce();
		if (service.updateStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Updated Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}

}