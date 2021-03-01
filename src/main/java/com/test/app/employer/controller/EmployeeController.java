package com.test.app.employer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.test.app.employer.dto.EmployeeDTO;
import com.test.app.employer.dto.ResponseDTO;
import com.test.app.employer.service.EmployeeService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@CrossOrigin("*")
public class EmployeeController {
	
	Logger logs = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ResponseDTO responseDto;
	
	/*Edit Employee Data By Id*/
	@GetMapping("/edit/{id}")
	public String findById(@PathVariable Long id,Model model){
		EmployeeDTO empDTO = empService.findById(id);
		logs.debug("Found Data by ID : ", empDTO);
		model.addAttribute("employeeData",empDTO);
		return "edit-employee";
	}
	
	/*Insert Employee Data*/
	@PostMapping("/addEmp")
	public String insertData(@ModelAttribute(value = "empData") EmployeeDTO empData, BindingResult result, RedirectAttributes redirectAttributes){
		logs.info("Saved Data by ID : "+ empData);
		if(result.hasErrors()){
			return "Errors";
		}
		empService.save(empData);
		redirectAttributes.addFlashAttribute("message","Added Successfully");
		redirectAttributes.addFlashAttribute("alertClass","alert-success");
		return "redirect:/index";
	}
	
	/*Update Employee Data*/
	@PostMapping("/update")
	public String updateData(@ModelAttribute(value = "employeeData") EmployeeDTO employeeData, BindingResult result, RedirectAttributes redirectAttributes){
		logs.info("Saved Data by ID : "+ employeeData);
		if(result.hasErrors()){
			return "Errors";
		}
		EmployeeDTO empDTO = empService.save(employeeData);
		redirectAttributes.addFlashAttribute("message","Updated Successfully!!");
		redirectAttributes.addFlashAttribute("alertClass","alert-success");

		return "redirect:/index";
	}
	
	/*Delete Employee Data*/
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") long id,Model model){
		logs.debug("REST request to delete Tech Qualities : {}", id);
		EmployeeDTO empDto = empService.findById(id);
			empService.deleteById(empDto.getId());
		return "redirect:/index";
	}

	/*Get All Employers Data*/
	@GetMapping("/index")
	public String findAll(Model model){
		List<EmployeeDTO> empDto = empService.getAll();;
		model.addAttribute("empsData",empDto);
		return "index";
	}

	/*Add Employee Page*/
	@GetMapping("/add-emp")
	public String empRealData(Model model){
		model.addAttribute("empData",new EmployeeDTO());
		return "add-user";
	}


	

}
