package com.students.repositor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.students.entity.StudentInfo;


public interface StudentRepository extends CrudRepository<StudentInfo, Integer> {
	@Query(value="select * from student_info as stu where stu.pin_no =:pinno" , nativeQuery = true)
	StudentInfo findByPinNo(String pinno);
	

}
