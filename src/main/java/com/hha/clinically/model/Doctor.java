package com.hha.clinically.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "doctor")
@Accessors
@Data
@Getter
@Setter
public class Doctor {
		
	@Id
	@Column(name = "doc_id") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long doc_id;
	 
	
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "designation", nullable = true)
    private String designation;
	
    @Column(name = "regNo", nullable = true)
    private String regNo;
    
    @Column(name = "specialization", nullable = true)
    private String specialization;
    
    @ElementCollection	
    @CollectionTable(name = "doctor_patients_ids", joinColumns = @JoinColumn(name = "doctor_doc_id"))
	@Column(name = "patientIds", nullable = true)	
	private List<String> patientIds;   
       
    	
	public Doctor() {
		
	}
	public Doctor(Long docId, String name, String designation, String regNo, String specialization) {
		super();
		this.doc_id = doc_id;
		this.name = name;
		this.designation = designation;
		this.regNo = regNo;
		this.specialization = specialization;
	}
	
  
	public Long getDocId() {
		return doc_id;
	}
	

	public void setDocId(Long docId) {
		this.doc_id = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	public List<String> getPatientIds() {
		return patientIds;
	}
	public void setPatientIds(List<String> patientIds) {
		this.patientIds = patientIds;
	}

    
	
	
	

}
