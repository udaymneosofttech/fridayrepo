package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.authenticate.EmployeeRegistrationcommand;
import com.neosoft.authenticate.EmployeeRegistrationdto;
import com.neosoft.repository.EmployeeDaoimpl;
import com.neosoft.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	@Autowired
	private EmployeeDaoimpl dao;
	
	
	
	public List<String> getCounties(){
		
		
		
		return null;
		
	}
	
	@RequestMapping(value="auth.do",method=RequestMethod.POST)
	public String handlerAuthenticateDetails(@ModelAttribute("registrationcommand") 
	                                         EmployeeRegistrationcommand registrationcommand){
		EmployeeRegistrationdto dto=new EmployeeRegistrationdto();
		BeanUtils.copyProperties(registrationcommand, dto);
		//System.out.println(registrationcommand.getUsername()+" "+registrationcommand.getSno()+""+registrationcommand.getPassword());
		
		String str=service.authenticateDetails(dto);
		System.out.println(str);
		System.out.println("successfully completed");
		return "Regsuccess";
		
	}
	
	
	@RequestMapping(value="login.do",method=RequestMethod.GET)
	public void authenticateCheck(@RequestParam("uname") String uname){
		
		service.getAuthenticateDetails(uname);
	//	return "";
		
	}
	@RequestMapping(value="c.do",method=RequestMethod.GET)
	public void createCountries(){
		
		dao.createCountries();
	//	return "";
		
	}
	
	

}
