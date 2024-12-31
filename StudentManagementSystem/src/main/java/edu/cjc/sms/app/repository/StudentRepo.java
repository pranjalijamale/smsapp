package edu.cjc.sms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.sms.app.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
