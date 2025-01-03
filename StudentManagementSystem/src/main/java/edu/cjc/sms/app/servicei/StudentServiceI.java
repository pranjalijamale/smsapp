package edu.cjc.sms.app.servicei;


import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

	public void addStudent(Student s);

	public List<Student> getAllStudent();

	
	public List<Student> searchStudentByBatch(String batchNumber);

	public Student getSingleStudent(int id);

	public void updateStudentFees(int studentid, float ammount);

	public void removeStudent(int id);

	public List<Student> shiftBatch(int studentid, String batchNumber, String batchMode);

	List<Student> paging(int pageNo, int i);

	

}
