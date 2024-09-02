package com.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.students.entity.StudentInfo;
import com.students.service.ApiResponse;
import com.students.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
// post data into DB	
	@PostMapping("/postData")
	public ResponseEntity<ApiResponse<StudentInfo>> storeData(@RequestBody StudentInfo students) {
		
		return new ResponseEntity<>(new ApiResponse<>("DataPostedSuccessfully", service.storeData(students)), HttpStatus.CREATED);
		
	}
	
// get data from DB	
	@GetMapping("/getData")
	public ResponseEntity<ApiResponse<List<StudentInfo>>> getData(){
		List<StudentInfo>  info=service.getData();
		return new ResponseEntity<>(new ApiResponse<>("HereYourData", info) , HttpStatus.OK);
	}
	
// get student Details by pin Number from DB
	@GetMapping("/getData/{pinno}")
	public ResponseEntity<ApiResponse<StudentInfo>> dataByPinNo(@PathVariable String pinno){
		StudentInfo infor =service.dataByPinNo(pinno);
		if(infor == null)
				return new ResponseEntity<>(new ApiResponse<>("StudentNotFound", infor),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(new ApiResponse<>("Here is the Student Data", infor),HttpStatus.ACCEPTED);
	}

	
// update Students  Details
	@PutMapping("/updateData/{pinno}")
	public ResponseEntity<ApiResponse<StudentInfo>> dataUpdation(@PathVariable String pinno, @RequestBody StudentInfo student){
		StudentInfo updatedData= service.dataUpdation(pinno, student);
		
		return new ResponseEntity<>(new ApiResponse<>("ScuessFully Updated",updatedData),HttpStatus.OK);
	}
}
