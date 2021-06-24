package com.hha.clinically.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private Long doc_id;
	 
	
    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "designation", nullable = true)
    private String designation;
	
    @Column(name = "regNo", nullable = true)
    private String regNo;
    
    @Column(name = "specialization", nullable = true)
    private String specialization;

    /*
	 * @Column(name = "patientIds", nullable = true)
	 * 
	 * @OneToMany(targetEntity=String.class, mappedBy="doctor",
	 * fetch=FetchType.EAGER) private List<String> patientIds;
	 */
    
  
	
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

    
	
	
	

}
