package com.vetan.data;

public class Tracker {
    
	private String id;
    private String claimdate;
    private String claimid;
    private String description;
    private String amount;
    private String status;
    private String payment;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClaimdate() {
		return claimdate;
	}
	public String getClaimid() {
		return claimid;
	}
	public String getDescription() {
		return description;
	}
	public String getAmount() {
		return amount;
	}
	public String getStatus() {
		return status;
	}
	public String getPayment() {
		return payment;
	}
	public void setClaimdate(String claimdate) {
		this.claimdate = claimdate;
	}
	public void setClaimid(String claimid) {
		this.claimid = claimid;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Tracker(String id, String claimdate, String claimid, String description, String amount, String status, String payment) {
		super();
		this.id = id;
		this.claimdate = claimdate;
		this.claimid = claimid;
		this.description = description;
		this.amount = amount;
		this.status = status;
		this.payment = payment;
	}

	

}

	

