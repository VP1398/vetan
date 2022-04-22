package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_petrol")
public class RemPEEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="expense_type")
	private String expenseType;

	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	@Column(name="bill_no")
	private String billNo;
	
	@Column(name="bill_date")
	private String billDate;
	
	@Column(name="no_litres")
	private String noOfLitres;

	@Column(name="rate")
	private String rate;
	
	@Column(name="claimed_amt")
	private String claimedAmount;

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

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getNoOfLitres() {
		return noOfLitres;
	}

	public void setNoOfLitres(String noOfLitres) {
		this.noOfLitres = noOfLitres;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(String claimedAmount) {
		this.claimedAmount = claimedAmount;
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
		return "RemPEEntity [id=" + id + ", expenseType=" +expenseType +
				", startDate=" + startDate +", endDate=" + endDate + 
				 ", billNo=" + billNo   + ", billDate=" +billDate   +
	            ", noOfLitres=" + noOfLitres + ", rate=" + rate +
               ", claimedAmount=" +claimedAmount + 
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}