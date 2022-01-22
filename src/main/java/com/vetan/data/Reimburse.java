package com.vetan.data;

public class Reimburse {
    
	    public Reimburse(String expense, String vendor, String inv_date, String inv_no, String inv_amt, String ent_amt,
			String claimed_amt, String remarks) {
		super();
		this.expense = expense;
		this.vendor = vendor;
		this.inv_date = inv_date;
		this.inv_no = inv_no;
		this.inv_amt = inv_amt;
		this.ent_amt = ent_amt;
		this.claimed_amt = claimed_amt;
		this.remarks = remarks;
	}
		public String getExpense() {
		return expense;
	}
	public String getVendor() {
		return vendor;
	}
	public String getInv_date() {
		return inv_date;
	}
	public String getInv_no() {
		return inv_no;
	}
	public String getInv_amt() {
		return inv_amt;
	}
	public String getEnt_amt() {
		return ent_amt;
	}
	public String getClaimed_amt() {
		return claimed_amt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}
	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}
	public void setInv_amt(String inv_amt) {
		this.inv_amt = inv_amt;
	}
	public void setEnt_amt(String ent_amt) {
		this.ent_amt = ent_amt;
	}
	public void setClaimed_amt(String claimed_amt) {
		this.claimed_amt = claimed_amt;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
		private String  expense;
	    private String  vendor;
	    private String  inv_date;
	    private String  inv_no;
	    private String  inv_amt;
	    private String  ent_amt;
	    private String  claimed_amt;
	    private String  remarks;


}

	

