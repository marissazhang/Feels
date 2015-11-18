package com.mie.model;

public class Symp_Res {
	
	private int symptomID;
	private int resourceID;
	private String symptomName;
	private String resourceName;
	
	public int getSymptomid(){
		return symptomID;
	}
	
	public String getSymptomName(){
		return symptomName;
	}

	public void setSymptomid (int symptomid) {
		this.symptomID = symptomid;
	}
	
	public void setSymptomName (String symptomName) {
		this.symptomName = symptomName;
	}
	
	public int getResourceID(){
		return resourceID;
	}
	
	public String getResourceName(){
		return  resourceName;

	}

	public void setResourceID (int resourceID) {
		this.resourceID = resourceID;
	}
	
	public void setResourceName (String resouceName) {
		this.resourceName =  resouceName;

	}
}
