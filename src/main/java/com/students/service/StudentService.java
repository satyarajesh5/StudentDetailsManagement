package com.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.entity.StudentInfo;
import com.students.repositor.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;

	public StudentInfo storeData(StudentInfo students) {
		
		return repo.save(students);
	}

	public List<StudentInfo> getData() {
		
		return (List<StudentInfo>) repo.findAll();
		
	}

	public StudentInfo dataByPinNo(String pinno) {
		
		return repo.findByPinNo(pinno);
		
	}

	public StudentInfo dataUpdation(String pinno, StudentInfo student) {
		StudentInfo existingData =repo.findByPinNo(pinno);
		
		if(existingData == null)
			return null;
		if(student.getFirstName() != null)
			existingData.setFirstName(student.getFirstName());
		if(student.getLastName() != null)
			existingData.setLastName(student.getLastName());
		if(student.getPinNo()!=null)
			existingData.setPinNo(student.getPinNo());;
		if(student.getCourse() !=null)
			existingData.setCourse(student.getCourse());
		if(student.getYear() >= 0)
			existingData.setYear(student.getYear());
		if(student.getStatus() != null)
			existingData.setStatus(student.getStatus());
		
		
		
		return repo.save(existingData);
	}

}
