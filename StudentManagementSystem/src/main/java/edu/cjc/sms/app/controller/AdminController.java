package edu.cjc.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServiceI;


@Controller
public class AdminController {
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")//root url/
	public String preLogin() {
		
		return "login";
	}

	@RequestMapping("/login")
	public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
		System.out.println(username);
		System.out.println(password);
		
		if(username.equals("admin")&& password.equals("admin")) {
			List<Student> stulist=ssi.getAllStudent();
			m.addAttribute("data", stulist);
			
		return "admin";
		}
		else {
		return "login";
		}
		
	}
	@RequestMapping("enroll_student")
	public String addStudent(@ModelAttribute Student s, Model m) {
	 ssi.addStudent(s);
		List<Student> list=ssi.getAllStudent();
		m.addAttribute("data", list);
		return "admin";
	}
	
	@RequestMapping("/Search")
	public String searchStudent(@RequestParam("batchNumber") String batchNumber, Model m) {
		
		List<Student> result=ssi.searchStudentByBatch(batchNumber);
		if(result.size()>0) {
		
		m.addAttribute("data", result);
		
		}
		else {
			List<Student> students= ssi.getAllStudent();
			m.addAttribute("data", students);
			m.addAttribute("message","Student records not available");
			
		}
		return "admin";
	}
	
	@RequestMapping("/fees")
	public String onFess(@RequestParam int id, Model m) {
		
		Student st= ssi.getSingleStudent(id);
		m.addAttribute("st", st);
		
		return "fees";
		
	}
	
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int studentid, @RequestParam float ammount, Model m) {
		
		ssi.updateStudentFees(studentid, ammount);
		
		List<Student> students= ssi.getAllStudent();
		m.addAttribute("data", students);
		return "admin";
	}
	
	
	
	@RequestMapping("/remove")
	public String removeDelete(@RequestParam("id") int id,Model m) {		
		 ssi.removeStudent(id);
		 List<Student>list= ssi.getAllStudent();
		 m.addAttribute("data", list);
		return"admin";
	}
	@RequestMapping("/batch")
	public String onbatch(@RequestParam int id, Model m) {
		
		Student st= ssi.getSingleStudent(id);
		m.addAttribute("st", st);
		
		return "shiftbatch";
		
	}
	
	
	@RequestMapping("/batchshift")
	public String changeBatch(@RequestParam("studentId") int studentid, @RequestParam("batchNumber") String batchNumber,@RequestParam("batchMode") String batchMode, Model m) {
		List<Student> list=ssi.shiftBatch(studentid, batchNumber, batchMode);
		m.addAttribute("st", list);
		
		return"admin";
		
	}


	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m) {
		List<Student> list=ssi.paging(pageNo,5);
		m.addAttribute("data",list);
		return "admin";
	}

	
	
}
