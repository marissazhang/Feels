package com.mie.model;

public class Symptom {
	private int symptomid;
	private String symptomName;
	
	
	public int getSymptomid(){
		return symptomid;
	}
	
	public String getSymptomName(){
		return symptomName;
	}

	public void setSymptomid (int symptomid) {
		this.symptomid = symptomid;
	}
	
	public void setSymptomName (String symptomName) {
		this.symptomName = symptomName;
	}
	
}
