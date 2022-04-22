   package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_ctm")
public class RemCtmEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="claim_date")
	private Date ClaimDate;
	
	@Column(name="emp_code")
	private String empCode;

	@Column(name="name")
	private String name;
	
	@Column(name="expense_type")
	private String expenseType;

	@Column(name="vendor_name")
	private String vendorName;

	@Column(name="inv_date")
	private Date invoiceDate;

	@Column(name="inv_no")
	private String invoiceNo;
	
	@Column(name="inv_amt")
	private double invoiceAmount;

	@Column(name="ent_amt")
	private double entitledAmount; 
	
	@Column(name="claimed_amt")
	private double claimedAmount;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="status")
	private String status;
	
	@Column(name="mremarks")
	private String mremarks;
	
	@Column(name="date")
	private Date date;

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

    
	public Date getClaimDate() {
		return ClaimDate;
	}

	public void setClaimDate(Date claimDate) {
		ClaimDate = claimDate;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMremarks() {
		return mremarks;
	}

	public void setMremarks(String mremarks) {
		this.mremarks = mremarks;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "RemCtmEntity [id=" + id + ", ClaimDate =" +ClaimDate +
				",empCode="+ empCode + ", name=" + name +
				", expenseType=" + expenseType + ", vendorName=" + vendorName   + 
				 ", invoiceDate=" + invoiceDate   + ", invoiceNo=" + invoiceNo +
                ", invoiceAmount=" + invoiceAmount + ", entitledAmount="+ entitledAmount+
                ", claimedAmount=" +claimedAmount + ", remarks="+ remarks+
                ",status=" + status + ", mremarks=" + mremarks + ", date=" + date + ", attachments=" + attachments +"]";
	}
}