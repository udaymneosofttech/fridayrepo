package com.neosoft.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.authenticate.EmployeeRegistrationHLO;
import com.nt.domain.CountryHlo;
import com.nt.domain.StateHlo;

@Repository
public class EmployeeDaoimpl {
	//private String query="select password e from EmployeeRegistrationHLO e where username=:username";

	@Autowired
	private HibernateTemplate ht;
	
	
	public List<String> getCountries(){
		
		
		return null;
		
		
	}
	
	
//	public void getEmployeeauthentication_details(@ModelAttribute("authenticatedetails")
//	                                                 EmployeeRegistrationdto authenticatedetails){
//		
//		
//		
//	}
	
	public int insertAuthenticateDetails(EmployeeRegistrationHLO hlo){
		int i=0;
		try{
			
		
		
		System.out.println(hlo.getSno()+"...."+hlo.getEmail()+"----"+hlo.getPassword()+"---"+hlo.getUsername());
		
		 i=(Integer) ht.save(hlo);
		return i;
		}catch(Exception e){
			e.printStackTrace();
			return i;
		}
		
	}
	
	
	
	
	public String getAuthenticateDetails(String user){
		
		@SuppressWarnings("unchecked")
		List<String> list=(List<String>) ht.findByNamedQueryAndNamedParam("q1", "username", user);
		for(String s:list){
		System.out.println(s);
		}
		return 1+"";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Through programatically i wil insert countries and states
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="hbtxmg")
	
	public int createCountries(){
	StateHlo s=new StateHlo();
	s.setSname("A.P");
	StateHlo s1=new StateHlo();
	s1.setSname("telangana");
	StateHlo s2=new StateHlo();
	s.setSname("maharastra");
	StateHlo s3=new StateHlo();
	s1.setSname("tamilnadu");
	StateHlo s4=new StateHlo();
	s1.setSname("karnataka");
	List<StateHlo> list=new ArrayList<StateHlo>();
	list.add(s1);
	list.add(s2);
	list.add(s3);
	list.add(s4);
	
	CountryHlo c=new CountryHlo();
	c.setCountryname("india");
	c.setList(list);
	ht.save(c);
	
	
		return 0;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
