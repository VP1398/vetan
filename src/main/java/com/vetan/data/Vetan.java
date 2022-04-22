package com.vetan.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "reimburse")
public class Vetan {
	  @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;

	  private String name;

	  private String type;
	  
      private String expense;
	  
	  private String vendor;
	  
	  private String inv_no;
	  
	  private String inv_date;
	  
	  private String inv_amt;
	  
	  private String ent_amt;
	  
	  private String claimed_amt;
	  
	  private String remarks;
	  

	  @Lob
	  private byte[] data;

	  public Vetan() {
	  }

	  public Vetan(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }
	  
	  public Vetan(String name, String type, byte[] data,String expense,String vendor,String  inv_no,String inv_date,String inv_amt,String ent_amt,String claimed_amt,String remarks) {
		    this.name = name;
		    this.type = type;
		    this.data = data;
		    this.expense = expense;
		    this.vendor = vendor;
		    this.inv_no = inv_no;
		    this.inv_date = inv_date;
		    this.inv_amt = inv_amt;
		    this.ent_amt = ent_amt;
		    this.claimed_amt = claimed_amt;
		    this.remarks = remarks;
		  }

	  public String getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public byte[] getData() {
	    return data;
	  }

	  public void setData(byte[] data) {
	    this.data = data;
	  }

	public void setId(String id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getInv_no() {
		return inv_no;
	}

	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}

	public String getInv_date() {
		return inv_date;
	}

	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}

	public String getInv_amt() {
		return inv_amt;
	}

	public void setInv_amt(String inv_amt) {
		this.inv_amt = inv_amt;
	}

	public String getEnt_amt() {
		return ent_amt;
	}

	public void setEnt_amt(String ent_amt) {
		this.ent_amt = ent_amt;
	}

	public String getClaimed_amt() {
		return claimed_amt;
	}

	public void setClaimed_amt(String claimed_amt) {
		this.claimed_amt = claimed_amt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
