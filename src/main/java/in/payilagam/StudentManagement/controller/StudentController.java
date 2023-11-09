package in.payilagam.StudentManagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;
import in.payilagam.StudentManagement.entity.StudentEntity;
import in.payilagam.StudentManagement.repository.StudentRepo;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("student")
	public ModelAndView display() {
		ModelAndView mav = new ModelAndView("students");
		mav.addObject("studentList",repo.findAll());
		return mav;
	}
	
	@RequestMapping("/student/new")
	public ModelAndView addStudent(StudentEntity stud) {
		//System.out.println(stud.getEmail());
		System.out.println(stud.getName());
		ModelAndView mav = new ModelAndView("createStudent");
		mav.addObject("studentObj",stud);
		return mav;
	}
	
	@PostMapping("/student")
	public String saveStuent(StudentEntity stud) {
		//System.out.println(stud.getName());
		repo.save(stud);
		return "redirect:/student";
	}
	
	@RequestMapping("/student/edit/{id}")
	public ModelAndView editStudent(@PathVariable long id) {
		ModelAndView mav = new ModelAndView("editStudentdetail");
		StudentEntity stud =  repo.findById(id).get();
		mav.addObject("studentObj",stud);
		return mav;
		
	}
	
	@PostMapping("/student/update/{id}")
	public String updateStudent(StudentEntity stud) {
		repo.save(stud);
		return "redirect:/student";
	}
		
	@PostMapping("/student/{id}")
	public String deleteStudentById( Long id) 
	{
		repo.deleteById(id);
	    return "redirect:/student";
	}
}
	

	
	
	
	
	
	
	
	
	

