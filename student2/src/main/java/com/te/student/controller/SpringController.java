package com.te.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SpringController {
	@GetMapping("/")
	public String firstHandlerMethod() {
		return "TechnoElevateRajeswari";
		
	}
}
