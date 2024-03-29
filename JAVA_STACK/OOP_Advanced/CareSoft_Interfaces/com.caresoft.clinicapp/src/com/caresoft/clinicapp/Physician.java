package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User  implements HIPAACompliantUser {


    
    // Inside class:    
    private ArrayList<String> patientNotes;
    
    // TO DO: Constructor that takes an ID
    
    public Physician(Integer id) {
    	super(id);
    	// TODO Auto-generated constructor stub
    }
   
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	@Override
	public boolean assignPin(int pin) {
		if (pin >=999 && pin <= 9999) {
			this.setPin(pin);			
			return true;
		}
		else 
		return false;
		
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.getId()== confirmedAuthID ) {
			return true;
		}
		else {
		return false;
	}
	
    // TO DO: Setters & Getters

	}
}
