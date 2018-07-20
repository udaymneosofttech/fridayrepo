package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="states")
public class StateHlo {
	
	
	@Id
	@GenericGenerator(name = "g1", strategy = "increment")
	@GeneratedValue(generator="g1")
	private int ssno;
	private String sname;
	public int getSsno() {
		return ssno;
	}
	public void setSsno(int ssno) {
		this.ssno = ssno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	

}
