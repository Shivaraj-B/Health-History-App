package com.hha.clinically.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hha.clinically.model.Doctor;
import com.hha.clinically.service.DoctorService;
import com.hha.clinically.util.CustomErrorType;




@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
	
	public static final Logger log = LoggerFactory.getLogger(DoctorController.class);
	@Autowired
	private DoctorService doctorService;

	@GetMapping(path = "Hello")
	public String printHelloDoctor() {
		System.out.println("Hello Doctor");
		return "Hello Doctorsss";
	}
	
	@PostMapping("/addDoctor")
	public  ResponseEntity<?> addDoctor(@RequestBody Doctor doctor, UriComponentsBuilder ucBuilder) {
		log.info("Adding a Doctor info: {}", doctor.toString());
		doctorService.addDoctor(doctor);
		
		 HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/api/v1/doctor/{id}").buildAndExpand(doctor.getDocId()).toUri());
	     return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/doctors")
	  public ResponseEntity<List<Doctor>> getAllDoctors() {
		log.info("Getting all available doctors}");
		List<Doctor> docs = doctorService.getAllDoctors();		
		 if (docs.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Doctor>>(docs, HttpStatus.OK);	    
	  }
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<?> getDoctorById(@PathVariable("id") long id) {
        log.info("Fetching Doctor with id {}", id);
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            log.error("Doctor with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Doctor with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDoctorById(@PathVariable ("id") long id) {
		log.info("Fetching & Deleting Doctor with id {}", id);
		Doctor doctor = doctorService.getDoctorById(id);
        if (doctor == null) {
            log.error("Doctor with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete Doctor with id " + id 
                    + " Since its not found"), HttpStatus.NOT_FOUND);
        }
		
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctorById(@PathVariable ("id") long id, @RequestBody Doctor doctor) {
		log.info("Fetching & updating the Doctor with id {}", id);
		Doctor currentDoctor = doctorService.getDoctorById(id);
        if (currentDoctor == null) {
            log.error("Doctor with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to update the Doctor with id " + id 
                    + " Since its not found"), HttpStatus.NOT_FOUND);
        }
		
        doctorService.updateDoctorInfo(doctor,currentDoctor);
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@PutMapping("/{id}/patient")
	public ResponseEntity<?> updatePatientListById(@PathVariable ("id") long id, @RequestBody List<String> patients) {
		log.info("Updating the patient list for the Doctor with id {}", id);
		Doctor currentDoctor = doctorService.getDoctorById(id);
        if (currentDoctor == null) {
            log.error("Doctor with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to update the Doctor with id " + id 
                    + " Since its not found"), HttpStatus.NOT_FOUND);
        }
		
        doctorService.updatePatientsList(patients,currentDoctor);
        return new ResponseEntity<Doctor>(currentDoctor, HttpStatus.OK);
	}

	 	
}
