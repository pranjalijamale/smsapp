package edu.cjc.sms.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	

}
