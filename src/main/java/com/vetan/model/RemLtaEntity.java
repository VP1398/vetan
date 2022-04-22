package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_lta")
public class RemLtaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="expense_type")
	private String expenseType;

	@Column(name="pl_status")
	private String plStatus;

	@Column(name="lta_lve_period")
	private String ltaLeavePeriod;

	@Column(name="egb_block_year")
	private String egbBlockYear;
	
	@Column(name="no_egb_fmem")
	private String noEgbFmem;
	
	@Column(name="mem_traveled")
	private String actualMemTraveled;
	
	@Column(name="travel_egb")
	private String travelEgb;
	
	@Column(name="amt_egb")
	private String amountEgb;
	
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

	public String getPlStatus() {
		return plStatus;
	}

	public void setPlStatus(String plStatus) {
		this.plStatus = plStatus;
	}

	public String getLtaLeavePeriod() {
		return ltaLeavePeriod;
	}

	public void setLtaLeavePeriod(String ltaLeavePeriod) {
		this.ltaLeavePeriod = ltaLeavePeriod;
	}

	public String getEgbBlockYear() {
		return egbBlockYear;
	}

	public void setEgbBlockYear(String egbBlockYear) {
		this.egbBlockYear = egbBlockYear;
	}

	public String getNoEgbFmem() {
		return noEgbFmem;
	}

	public void setNoEgbFmem(String noEgbFmem) {
		this.noEgbFmem = noEgbFmem;
	}
	

	public String getActualMemTraveled() {
		return actualMemTraveled;
	}

	public void setActualMemTraveled(String actualMemTraveled) {
		this.actualMemTraveled = actualMemTraveled;
	}

	public String getTravelEgb() {
		return travelEgb;
	}

	public void setTravelEgb(String travelEgb) {
		this.travelEgb = travelEgb;
	}

	
	public String getAmountEgb() {
		return amountEgb;
	}

	public void setAmountEgb(String amountEgb) {
		this.amountEgb = amountEgb;
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
		return "RemLtaEntity [id=" + id + ", expenseType=" + expenseType +
				", plStatus=" + plStatus + ", ltaLeavePeriod=" + ltaLeavePeriod   +
	            ", egbBlockYear=" + egbBlockYear+ ", noEgbFmem=" + noEgbFmem   +
                ", travelEgb=" + travelEgb + ", amountEgb	=" + amountEgb	 +
                ", claimedAmount="+ claimedAmount+ ", actualMemTraveled="+ actualMemTraveled+
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}