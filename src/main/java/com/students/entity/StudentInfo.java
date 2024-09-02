package com.students.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentInfo {
	
	@Id
	@Column(unique = true)
	private String pinNo;
	private String firstName;
	private String lastName;
	private String course;
	private int year;
	private String status;
	
	StudentInfo(){}

	public StudentInfo(String pinNo, String firstName, String lastName, String course, int year,
			String status) {
		super();
		this.pinNo = pinNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.year = year;
		this.status = status;
	}



	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "StudentInfo [pinNo=" + pinNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", course=" + course + ", year=" + year + ", status=" + status + "]";
	}
	
	

}
