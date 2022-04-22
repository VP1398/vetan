package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_travel")
public class RemTravelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="start")
	private Date startDateTime;

	@Column(name="end")
	private Date endDateTime;

	@Column(name="no_of_days")
	private String noOfDays;

	@Column(name="expense_desp")
	private String expenseDescription;
	
	@Column(name="expense_details")
	private String expenseDetails;
	
	@Column(name="amt")
	private double amount;

	@Column(name="remarks")
	private String remarks;

	@Column(name="attachments")
	private String attachments;

	@Lob
	@Column(name="attach")
	private byte[] attach;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public String getExpenseDetails() {
		return expenseDetails;
	}

	public void setExpenseDetails(String expenseDetails) {
		this.expenseDetails = expenseDetails;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public byte[] getAttach() {
		return attach;
	}

	public void setAttach(byte[] attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "RemTravelEntity [id=" + id + ", startDateTime =" + startDateTime +
				", endDateTime=" + endDateTime +", noOfDays=" + noOfDays + 
				 ", expenseDescription=" + expenseDescription   + ",expenseDetails=" + expenseDetails +   ", amount=" + amount + 
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}