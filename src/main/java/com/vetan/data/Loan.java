package com.vetan.data;


public class Loan {
	
	
   
	/**
	 * @return the ec
	 */
	public String getEc() {
		return ec;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @return the bcode
	 */
	public String getBcode() {
		return bcode;
	}
	/**
	 * @return the loan_type
	 */
	public String getLoan_type() {
		return loan_type;
	}
	/**
	 * @return the loan_amt
	 */
	public String getLoan_amt() {
		return loan_amt;
	}

	/**
	 * @param ec the ec to set
	 */
	public void setEc(String ec) {
		this.ec = ec;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * @param bcode the bcode to set
	 */
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	/**
	 * @param loan_type the loan_type to set
	 */
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	/**
	 * @param loan_amt the loan_amt to set
	 */
	public void setLoan_amt(String loan_amt) {
		this.loan_amt = loan_amt;
	}
	   private String id;
    private String ec;
    private String ename;
    private String area;
    private String bcode;
    private String loan_type;
    private String loan_amt;
	public Loan(String id, String ec, String ename, String area, String bcode, String loan_type, String loan_amt) {
		super();
		this.id = id;
		this.ec = ec;
		this.ename = ename;
		this.area = area;
		this.bcode = bcode;
		this.loan_type = loan_type;
		this.loan_amt = loan_amt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

 
}

	

