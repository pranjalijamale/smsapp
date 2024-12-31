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
		}else {
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
}
