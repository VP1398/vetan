package com.vetan.data;

public class Fee {
    
       private String ed_fee;
	   private String child;
	   private String relation;
	   private String academic;
	   private String school;
	   private String class1;
	   private String expense;
	   private String amount;
	   private String remarks;
	public String getEd_fee() {
		return ed_fee;
	}
	public String getChild() {
		return child;
	}
	public String getRelation() {
		return relation;
	}
	public String getAcademic() {
		return academic;
	}
	public String getSchool() {
		return school;
	}
	public String getClass1() {
		return class1;
	}
	public String getExpense() {
		return expense;
	}
	public String getAmount() {
		return amount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setEd_fee(String ed_fee) {
		this.ed_fee = ed_fee;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Fee(String ed_fee, String child, String relation, String academic, String school, String class1,
			String expense, String amount, String remarks) {
		super();
		this.ed_fee = ed_fee;
		this.child = child;
		this.relation = relation;
		this.academic = academic;
		this.school = school;
		this.class1 = class1;
		this.expense = expense;
		this.amount = amount;
		this.remarks = remarks;
	}


}

	

