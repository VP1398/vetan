package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_reimburse")
public class ReimburseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="exp_type")
	private String expenseType;

	@Column(name="vend_name")
	private String vendorName;

	@Column(name="inv_date")
	private Date invoiceDate;

	@Column(name="inv_no")
	private String invoiceNumber;

	@Column(name="inv_amt")
	private double invoiceAmount;

	@Column(name="ent_amt")
	private double entitledAmount;

	@Column(name="clm_amt")
	private double claimedAmount;

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

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public double getEntitledAmount() {
		return entitledAmount;
	}

	public void setEntitledAmount(double entitledAmount) {
		this.entitledAmount = entitledAmount;
	}

	public double getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(double claimedAmount) {
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
		return "ReimburseEntity [id=" + id + ", expenseType=" + expenseType +
				", vendorName=" + vendorName   + ", invoiceDate=" + invoiceDate   +
				", invoiceNumber=" + invoiceNumber   + ", invoiceAmount=" + invoiceAmount   +
				", entitledAmount=" + entitledAmount   + ", claimedAmount=" + claimedAmount   +
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}