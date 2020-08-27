package org.openmrs.module.labtest.pojo;

import java.io.Serializable;

import org.openmrs.BaseOpenmrsObject;

public class LaboratoryBean extends BaseOpenmrsObject implements Serializable {
	
	private static final long serialVesionUID = 1L;
	
	private int resultId;
	
	private String identifier;
	
	private String name;
	
	private String gender;
	
	private int age;
	
	private String oralResult;
	
	private double igGResult;
	
	private double igMResult;
	
	private String hormoneResult;
	
	private String symptoms;
	
	private String patientRecord;
	
	private String status;
	
	private String createTime;
	
	private String province;
	
	private String city;
	
	private String latitude;
	
	private String longitude;
	
	private boolean dead;
	
	private String deathDate;
	
	public LaboratoryBean() {
	}
	
	public int getResultId() {
		return resultId;
	}
	
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	@Override
	public Integer getId() {
		return getResultId();
	}
	
	@Override
	public void setId(Integer id) {
		setResultId(id);
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getOralResult() {
		return oralResult;
	}
	
	public void setOralResult(String oralResult) {
		this.oralResult = oralResult;
	}
	
	public double getIgGResult() {
		return igGResult;
	}
	
	public void setIgGResult(double igGResult) {
		this.igGResult = igGResult;
	}
	
	public double getIgMResult() {
		return igMResult;
	}
	
	public void setIgMResult(double igMResult) {
		this.igMResult = igMResult;
	}
	
	public String getHormoneResult() {
		
		hormoneResult = "Suspected";
		if (igMResult < 0.9 && igGResult < 0.9) {
			hormoneResult = "Negative";
		} else if (igMResult > 1.1 || igGResult > 1.1) {
			hormoneResult = "Positive";
		}
		return hormoneResult;
	}
	
	public void setHormoneResult(String hormoneResult) {
		this.hormoneResult = hormoneResult;
	}
	
	public String getSymptoms() {
		return symptoms;
	}
	
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public String getPatientRecord() {
		return patientRecord;
	}
	
	public void setPatientRecord(String patientRecord) {
		this.patientRecord = patientRecord;
	}
	
	public String getStatus() {
		status = "suspected";
		
		if ("Negative".equals(oralResult) && "Negative".equals(hormoneResult)) {
			status = "Negative";
		} else if ("Positive".equals(oralResult)) {
			status = "confirmed";
		} else if ("Negative".equals(oralResult) && "Positive".equals(hormoneResult)) {
			status = "cured";
		}
		
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public String getDeathDate() {
		return deathDate;
	}
	
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
}
