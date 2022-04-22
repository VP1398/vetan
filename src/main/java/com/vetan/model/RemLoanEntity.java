package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_loan")
public class RemLoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="loan_type")
	private String loanType;

	@Column(name="prdt_name")
	private String productName;
	
	@Column(name="prdt_type")
	private String productType;
	
	@Column(name="vend_name")
	private String vendorName;

	@Column(name="inv_no")
	private String invoiceNumber;
	
	@Column(name="inv_date")
	private Date invoiceDate;

	@Column(name="est_value")
	private double estimateValue;

	@Column(name="tot_est_value")
	private double totestValue;

	@Column(name="ent_amt")
	private double entitledAmount;
	
	@Column(name="req_amt")
	private double requestedAmount;

	@Column(name="no_of_instal")
	private String noofInstalments;
	
	@Column(name="int_rate")
	private double interestRate;
	
	@Column(name="emi")
	private double emi;
	
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


	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getEstimateValue() {
		return estimateValue;
	}

	public void setEstimateValue(double estimateValue) {
		this.estimateValue = estimateValue;
	}

	public double getTotestValue() {
		return totestValue;
	}

	public void setTotestValue(double totestValue) {
		this.totestValue = totestValue;
	}

	public double getEntitledAmount() {
		return entitledAmount;
	}

	public void setEntitledAmount(double entitledAmount) {
		this.entitledAmount = entitledAmount;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public String getNoofInstalments() {
		return noofInstalments;
	}

	public void setNoofInstalments(String noofInstalments) {
		this.noofInstalments = noofInstalments;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
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
		return "RemLoanEntity [id=" + id + ", loanType=" + loanType +", productName=" + productName +", productType=" + productType +
				", vendorName=" + vendorName   + ", invoiceDate=" + invoiceDate   +
				", invoiceNumber=" + invoiceNumber   + ", estimateValue=" + estimateValue   + ", totestValue=" + totestValue   +
				", entitledAmount=" + entitledAmount   + ", requestedAmount=" + requestedAmount   +
				", noofInstalments=" + noofInstalments +", interestRate=" + interestRate   + ", emi=" + emi   +
						", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}