package com.hotel.problem.models;


/**
 * Created by deepika sharma on 29/05/18.
 */

public class Guest {

    
    private String firstName;
    private String lastName;
    
    public Guest( String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


    @Override
    public String toString() {
        return "Guest{firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                
                '}';
    }
}
