package com.neosoft.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String getListedCountries(Map<String,Map<String,Integer>> map){
		
	//	dao.createCountries();
		LinkedHashMap<String,Integer> countrieslist= dao.getCountries();
		System.out.println(countrieslist+"................");
		map.put("countries", countrieslist);
		return "countries";
}
@RequestMapping(value="states.do",method=RequestMethod.GET)
public  @ResponseBody ArrayList<Object> getListedStates(@RequestParam("id") String id,Map<String,ArrayList<Object>> list){
	System.out.println("uday"+"...............ajax executed.");
	System.out.println(id+".....id got");
//	dao.createCountries();
	ArrayList<Object> statelist= dao.getStates(Integer.valueOf(id));

	list.put("states", statelist);
	return statelist;
}


}