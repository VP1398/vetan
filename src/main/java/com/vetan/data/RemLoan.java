package com.vetan.data;

public class RemLoan {
    
	
    private String  loan;
    private String  prod_name;
    private String  prod_type;
    private String  vendor;
    private String  inv_no;
    private String  inv_date;
    private String  est_val;
    private String  tot_est;
    private String  ent_amt;
    private String  req_amt;
    private String  remarks;
	public String getLoan() {
		return loan;
	}
	public String getProd_name() {
		return prod_name;
	}
	public String getProd_type() {
		return prod_type;
	}
	public String getVendor() {
		return vendor;
	}
	public String getInv_no() {
		return inv_no;
	}
	public String getInv_date() {
		return inv_date;
	}
	public String getEst_val() {
		return est_val;
	}
	public String getTot_est() {
		return tot_est;
	}
	public String getEnt_amt() {
		return ent_amt;
	}
	public String getReq_amt() {
		return req_amt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}
	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}
	public void setEst_val(String est_val) {
		this.est_val = est_val;
	}
	public void setTot_est(String tot_est) {
		this.tot_est = tot_est;
	}
	public void setEnt_amt(String ent_amt) {
		this.ent_amt = ent_amt;
	}
	public void setReq_amt(String req_amt) {
		this.req_amt = req_amt;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public RemLoan(String loan, String prod_name, String prod_type, String vendor, String inv_no, String inv_date,
			String est_val, String tot_est, String ent_amt, String req_amt, String remarks) {
		super();
		this.loan = loan;
		this.prod_name = prod_name;
		this.prod_type = prod_type;
		this.vendor = vendor;
		this.inv_no = inv_no;
		this.inv_date = inv_date;
		this.est_val = est_val;
		this.tot_est = tot_est;
		this.ent_amt = ent_amt;
		this.req_amt = req_amt;
		this.remarks = remarks;
	}

}

	

