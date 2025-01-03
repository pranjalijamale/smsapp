package edu.cjc.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.repository.StudentRepo;
import edu.cjc.sms.app.servicei.StudentServiceI;


@Service
public class StudentServiceImpl implements StudentServiceI{
	@Autowired
	StudentRepo sr;
	
	@Override
	public void addStudent(Student s) {
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}

	
	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		
		List<Student> studentBatch= sr.findByBatchNumber(batchNumber);
		return studentBatch;
	
				
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student> opStudent= sr.findById(id);
		return opStudent.get();
	}

	@Override
	public void updateStudentFees(int studentid, float ammount) {
		// TODO Auto-generated method stub
		Optional<Student> opStdent= sr.findById(studentid);
		
		Student students=opStdent.get();
		students.setFeesPaid(students.getFeesPaid()+ammount);
		sr.save(students);
	}

	@Override
	public void removeStudent(int id) {
		sr.deleteById(id);
		
		
	}

	@Override
	public List<Student> shiftBatch(int studentid, String batchNumber, String batchMode) {
		 Optional<Student> opStudent=sr.findById(studentid);
		 Student s= opStudent.get();
		 s.setBatchNumber(batchNumber);
		 s.setBatchMode(batchMode);
		 
		 sr.save(s);
		return sr.findAll();
		 
	
	
	}

	@Override
	public List<Student> paging(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("studentFullName").ascending());
		List<Student> list = sr.findAll(pageable).getContent();

		return list;
	}


	

	
	
	
	

}
