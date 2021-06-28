package com.hha.clinically.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hha.clinically.model.Doctor;
import com.hha.clinically.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository repo;		
	
	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> docs = new ArrayList<Doctor>();  
		repo.findAll().forEach(doctor -> docs.add(doctor));  
		return docs; 
	}

	@Override
	public void addDoctor(Doctor doc) {		
		repo.save(doc);		
	}

	@Override
	public Doctor getDoctorById(Long id) {
		return repo.findById(id).orElse(null);		
	}

	@Override
	public void deleteDoctorById(Long id) {
		repo.deleteById(id);		
	}

	@Override
	public void updateDoctorInfo(Doctor updatedDoctor, Doctor currentDoctor) {
		currentDoctor.setDesignation(updatedDoctor.getDesignation());
		currentDoctor.setName(updatedDoctor.getName());
		currentDoctor.setRegNo(updatedDoctor.getRegNo());
		currentDoctor.setSpecialization(updatedDoctor.getSpecialization());
		repo.save(currentDoctor);		
	}

	@Override
	public void updatePatientsList(List<String> patients, Doctor currentDoctor) {
		List<String> updatedPatientsList = currentDoctor.getPatientIds();
		updatedPatientsList.addAll(patients);
		currentDoctor.setPatientIds(updatedPatientsList);
		repo.save(currentDoctor);		
	}
	
	

}
