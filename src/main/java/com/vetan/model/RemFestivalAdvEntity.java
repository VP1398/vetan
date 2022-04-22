package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_festivaladv")
public class RemFestivalAdvEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="fest_name")
	private String festivalName;
	
	@Column(name="ent_amt")
	private double entitledAmount;

	@Column(name="req_amt")
	private double requiredAmount;

	@Column(name="no_of_instal")
	private String noOfInstalments;

	@Column(name="int_rate")
	private double interestRate;
	
	@Column(name="emi")
	private double emi;

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="pre_fest_name")
	private String preFestivalName;
	
	@Column(name="pre_date")
	private Date preDate;
	
	@Column(name="amount")
	private double amount;
	
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

	public String getFestivalName() {
		return festivalName;
	}

	public void setFestivalName(String festivalName) {
		this.festivalName = festivalName;
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

	public String getPreFestivalName() {
		return preFestivalName;
	}

	public void setPreFestivalName(String preFestivalName) {
		this.preFestivalName = preFestivalName;
	}

	public Date getPreDate() {
		return preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
		return "RemFestivalAdvEntity [id=" + id + 
				", festivalName=" + festivalName   + ", entitledAmount=" + entitledAmount   +
				", requiredAmount=" + requiredAmount   + ", noOfInstalments=" + noOfInstalments  +
				", interestRate=" + interestRate   + ", emi=" + emi  +
				", remarks=" + remarks + ", preFestivalName=" + preFestivalName   + 
				", preDate=" + preDate  +  ", amount=" + amount  + ", repaid=" + repaid   + 
				", balance=" + balance  + ", attachments=" + attachments +"]";
	}
}