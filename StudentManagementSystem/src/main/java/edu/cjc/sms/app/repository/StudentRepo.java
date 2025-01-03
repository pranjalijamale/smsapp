package edu.cjc.sms.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

public List<Student> findByBatchNumber(String bn );
//	List<Student> findAllByBatchNumber(String batchNumber);

//public List<Student> findByBatchNumber(String batchNumber, String batchMode);

	

}
