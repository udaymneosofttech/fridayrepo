package com.neosoft.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.neosoft.authenticate.EmployeeRegistrationHLO;
import com.nt.domain.CountryHlo;
import com.nt.domain.StateHlo;

@Repository
public class EmployeeDaoimpl {
	//private String query="select password e from EmployeeRegistrationHLO e where username=:username";

	@Autowired
	private HibernateTemplate ht;
	
	//String hqlquery="select c.csno,c.countryname from CountryHlo c where c.csno=2";
	private String hqlquerygetcountries="from CountryHlo c ";
	private String hqlquerygetstates="select sname from states where csno=:countryno";
	//private String hqlquerygetstates="select s.sname from states s where s.csno=:countryno";
	
	//getting countries
	public List<CountryHlo> getCountries(){
		//LinkedHashMap<String,Integer> countriesmap=new LinkedHashMap<>();
		List<CountryHlo> list1=new ArrayList<>();
		
		ht.execute(new HibernateCallback<CountryHlo>() {

			public CountryHlo doInHibernate(Session sess) throws HibernateException {
				
				Query query=sess.createQuery(hqlquerygetcountries);
			
				List<CountryHlo> list=query.list();
		    list1.addAll(list);
			
				//System.out.println(countriesmap);
				return null;
		}
		});
		return list1;
		
		
	}
	
	
	
	public ArrayList<Object> getStates(int i){
		ArrayList<Object> statelist=new ArrayList<>();
		
		ht.execute(new HibernateCallback<CountryHlo>() {

			public CountryHlo doInHibernate(Session sess) throws HibernateException {
				
				SQLQuery query=sess.createSQLQuery(hqlquerygetstates);
				query.setParameter("countryno", i);
				
				
				List<Object[]> list=query.list();
		
				
				for(Object obj:list){
					statelist.add((String)obj);
				}
				

				
				return null;
			}
		});
		return statelist;
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
	
	//@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="hbtxmg")
	
	public int createCountries(){
	StateHlo s=new StateHlo();
	s.setSname("bang1");
	StateHlo s1=new StateHlo();
	s1.setSname("bang2");
	StateHlo s2=new StateHlo();
	s2.setSname("bang3");
	StateHlo s3=new StateHlo();
	s3.setSname("bang4");
	StateHlo s4=new StateHlo();
	s4.setSname("bang5");
	List<StateHlo> list=new ArrayList<StateHlo>();
	list.add(s1);
	list.add(s2);
	list.add(s3);
	list.add(s4);
	
	CountryHlo c=new CountryHlo();
	c.setCountryname("bangladesh");
	c.setList(list);
	ht.save(c);
	
	
		return 0;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
