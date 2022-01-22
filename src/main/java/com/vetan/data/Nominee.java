package com.vetan.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nomination")
public class Nominee {
    @Id
	private Integer id;
	 private String type;
	 private String ec;
	 private String name;
	 private String aadhaar;
	 private String dob;
	 private String gender;
	 private String relation;
	 private String address;
	 private String proportion;

	 public Nominee(){

	 }

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProportion() {
		return proportion;
	}
	public void setProportion(String proportion) {
		this.proportion = proportion;
	}
	public Nominee( String name, String aadhaar, String dob, String gender, String relation,
			String address, String proportion) {
		super();

		this.name = name;
		this.aadhaar = aadhaar;
		this.dob = dob;
		this.gender = gender;
		this.relation = relation;
		this.address = address;
		this.proportion = proportion;
	}



}

	

