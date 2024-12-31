package edu.cjc.sms.app.servicei;


import java.util.List;

import edu.cjc.sms.app.model.Student;

public interface StudentServiceI {

	public void addStudent(Student s);

	public List<Student> getAllStudent();

}
