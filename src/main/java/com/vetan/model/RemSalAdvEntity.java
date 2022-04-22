package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_saladv")
public class RemSalAdvEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="adv_type")
	private String advanceType;

	@Column(name="sal_adv_reason")
	private String salaryAdvReason;
	
	@Column(name="ent_amt")
	private double entitledAmount;

	@Column(name="req_amt")
	private double requiredAmount;

	@Column(name="no_of_instal")
	private String noofInstalments;

	@Column(name="int_rate")
	private double interestRate;
	
	@Column(name="emi")
	private double emi;

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="pre_adv_reason")
	private String preAdvReason;
	
	@Column(name="pre_date")
	private Date preDate;
	
	@Column(name="amt")
	private double amt;
	
	@Column(name="repaid")
	private double repaid;
	
	@Column(name="balance")
	private double balance;

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

	public String getAdvanceType() {
		return advanceType;
	}

	public void setAdvanceType(String advanceType) {
		this.advanceType = advanceType;
	}

	public String getSalaryAdvReason() {
		return salaryAdvReason;
	}

	public void setSalaryAdvReason(String salaryAdvReason) {
		this.salaryAdvReason = salaryAdvReason;
	}

	public double getEntitledAmount() {
		return entitledAmount;
	}

	public void setEntitledAmount(double entitledAmount) {
		this.entitledAmount = entitledAmount;
	}

	public double getRequiredAmount() {
		return requiredAmount;
	}

	public void setRequiredAmount(double requiredAmount) {
		this.requiredAmount = requiredAmount;
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

	public String getPreAdvReason() {
		return preAdvReason;
	}

	public void setPreAdvReason(String preAdvReason) {
		this.preAdvReason = preAdvReason;
	}

	public Date getPreDate() {
		return preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public double getRepaid() {
		return repaid;
	}

	public void setRepaid(double repaid) {
		this.repaid = repaid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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
		return "RemSalAdvEntity [id=" + id + ", advanceType=" + advanceType +
				", salaryAdvReason=" + salaryAdvReason   + ", entitledAmount=" + entitledAmount   +
				", requiredAmount=" + requiredAmount   + ", noofInstalments=" + noofInstalments  +
				", interestRate=" + interestRate   + ", emi=" + emi  +
				", remarks=" + remarks + ", preAdvReason=" + preAdvReason   + 
				", preDate=" + preDate  + ", amt=" + amt  + ", repaid=" + repaid   + 
				", balance=" + balance  + ", attachments=" + attachments +"]";
	}
}