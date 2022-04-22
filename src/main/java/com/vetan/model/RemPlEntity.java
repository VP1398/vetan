package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_pl")
public class RemPlEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="expense_type")
	private String expenseType;

	@Column(name="type")
	private String type;
	
	@Column(name="pl_bal")
	private String plBalance;

	@Column(name="no_days")
	private String noOfDays;
	
	@Column(name="new_pl_bal")
	private String newPlBalance;
	
	@Column(name="claim_amt")
	private String claimAmount;

	@Column(name="avl_days")
	private String availedDays;
	
	@Column(name="bal_days")
	private String balanceDays;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlBalance() {
		return plBalance;
	}

	public void setPlBalance(String plBalance) {
		this.plBalance = plBalance;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getNewPlBalance() {
		return newPlBalance;
	}

	public void setNewPlBalance(String newPlBalance) {
		this.newPlBalance = newPlBalance;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getAvailedDays() {
		return availedDays;
	}

	public void setAvailedDays(String availedDays) {
		this.availedDays = availedDays;
	}

	public String getBalanceDays() {
		return balanceDays;
	}

	public void setBalanceDays(String balanceDays) {
		this.balanceDays = balanceDays;
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
		return "RemPlEntity [id=" + id + ", expenseType=" + expenseType +
						", type=" + type+", plBalance=" + plBalance + 
						 ", noOfDays=" + noOfDays   + ", newPlBalance=" + newPlBalance  +
			            ", claimAmount=" + claimAmount + ", availedDays=" + availedDays +
		                ", balanceDays=" + balanceDays +
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}