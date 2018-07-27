package com.nt.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="countries")
public class CountryHlo {
	
	@Id
	@GenericGenerator(name = "g1", strategy = "increment")
	@GeneratedValue(generator="g1")
	private int csno;
	private String countryname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="csno")
	@OrderColumn(name="listint")
	List<StateHlo> list;
	public void setList(List<StateHlo> list) {
		this.list = list;
	}
	public List<StateHlo> getList() {
		return list;
	}
	public int getCsno() {
		return csno;
	}
	public void setCsno(int csno) {
		this.csno = csno;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	@Override
	public String toString() {
		return "CountryHlo [csno=" + csno + ", countryname=" + countryname + ", list=" + list + "]";
	}
	
	
	
}
