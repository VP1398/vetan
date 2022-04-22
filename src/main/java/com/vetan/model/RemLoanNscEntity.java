package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_loannsc")
public class RemLoanNscEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="loan_type")
	private String loanType;

	@Column(name="nsc_no")
	private String nscNumber;

	@Column(name="no_of_certificates")
	private String noOfCertificates;

	@Column(name="nsc_purchase_date")
	private Date nscPurchaseDate;
	
	@Column(name="nsc_value")
	private String nscValue;

	@Column(name="nsc_maturity_date")
	private Date nscMaturityDate;
	
	@Column(name="req_amt")
	private double requestedAmount;

	@Column(name="no_of_instalments")
	private String noOfInstalments;
	
	@Column(name="interest_rate")
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

	public String getNscNumber() {
		return nscNumber;
	}

	public void setNscNumber(String nscNumber) {
		this.nscNumber = nscNumber;
	}

	public String getNoOfCertificates() {
		return noOfCertificates;
	}

	public void setNoOfCertificates(String noOfCertificates) {
		this.noOfCertificates = noOfCertificates;
	}

	public Date getNscPurchaseDate() {
		return nscPurchaseDate;
	}

	public void setNscPurchaseDate(Date nscPurchaseDate) {
		this.nscPurchaseDate = nscPurchaseDate;
	}

	public String getNscValue() {
		return nscValue;
	}

	public void setNscValue(String nscValue) {
		this.nscValue = nscValue;
	}

	public Date getNscMaturityDate() {
		return nscMaturityDate;
	}

	public void setNscMaturityDate(Date nscMaturityDate) {
		this.nscMaturityDate = nscMaturityDate;
	}

	public double getRequestedAmount() {
		return requestedAmount;
	}

	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}

	public String getNoOfInstalments() {
		return noOfInstalments;
	}

	public void setNoOfInstalments(String noOfInstalments) {
		this.noOfInstalments = noOfInstalments;
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
		return "RemLoanNscEntity [id=" + id + ", loanType=" + loanType   + ", nscNumber=" + nscNumber   +
				", noOfCertificates=" + noOfCertificates   + ", nscPurchaseDate=" + nscPurchaseDate   +
				", nscValue=" + nscValue   + ", nscMaturityDate=" + nscMaturityDate   +
				", requestedAmount=" + requestedAmount   + ", noOfInstalments=" + noOfInstalments   +
				", interestRate=" + interestRate   + ", emi=" + emi   +
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}