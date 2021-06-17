package com.hha.clinically.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

	@GetMapping(path = "Hello")
	public String printHelloDoctor() {
		System.out.println("Hello Doctor");
		return "Hello Doctorsss";
	}
	
}
