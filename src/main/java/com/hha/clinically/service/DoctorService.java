package com.hha.clinically.service;

import java.util.List;

import com.hha.clinically.model.Doctor;

public interface DoctorService {
	
	public List<Doctor> getAllDoctors();
	
	public void addDoctor(Doctor doc);
	
	public Doctor getDoctorById(Long id);

	public void deleteDoctorById(Long id);
	
	public void updateDoctorInfo(Doctor doc, Doctor currentDoctor);
	
	public void updatePatientsList(List<String> patients, Doctor currentDoctor);
}
