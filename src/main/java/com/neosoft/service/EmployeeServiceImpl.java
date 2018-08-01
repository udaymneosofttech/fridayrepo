package com.neosoft.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.authenticate.EmployeeRegistrationHLO;
import com.neosoft.authenticate.EmployeeRegistrationdto;
import com.neosoft.repository.EmployeeDaoimpl;
import com.nt.domain.CountryHlo;


@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeDaoimpl dao;
	
	//saving authenticate details\
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="hbtxmg")
	public String authenticateDetails(EmployeeRegistrationdto dto){
		EmployeeRegistrationHLO hlo=new EmployeeRegistrationHLO();
		BeanUtils.copyProperties(dto, hlo);
		
		int i=dao.insertAuthenticateDetails(hlo);
		System.out.println(i);
		if(i==1)
			return "authenticarte details inserted successfully";
		else
			return "authenticate details not inserted";
		
		
	}
	
	public void  getAuthenticateDetails(String user){
		
		dao.getAuthenticateDetails(user);
	}
	
	private Map<String,Integer> map=new LinkedHashMap<>();
	
	public Map<String,Integer> getListedCountries(){
		
		
		List<CountryHlo> list=dao.getCountries();
		
		list.forEach(s->{
			
			map.put(s.getCountryname(),s.getCsno());
		});
		return map;
	}
	
	public List<Object> getlistedstates(String countrykey){
		int value=0;
		List<Object> list=null;
		if(map.containsKey(countrykey)){
			
			value=map.get(countrykey);
		list=dao.getStates(value);
		}
		return list;
		
		
	}
	
	

}
