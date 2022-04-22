package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_ct")
public class RemCtEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name="claim_date")
	private Date claimDate;

	@Column(name="claim_id")
	private String claimId;
	
	@Column(name="description")
	private String description;

	@Column(name="claim_amt")
	private String claimAmount;
	
	@Column(name="apvl_status")
	private String approvalStatus;
	
	@Column(name="apvl_date")
	private Date approvalDate;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="settled_date")
	private Date settledDate;
	
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
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	

	public Date getSettledDate() {
		return settledDate;
	}

	public void setSettledDate(Date settledDate) {
		this.settledDate = settledDate;
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
		return "RemCtEntity [id=" + id + ", claimDate=" +claimDate +
				", claimId=" + claimId +", description=" + description + 
				 ", claimAmount=" + claimAmount   + ", approvalStatus=" + approvalStatus   +
	            ", approvalDate=" + approvalDate +  ", paymentStatus=" + paymentStatus +
	            ", settledDate=" + settledDate +
			    ", attachments=" + attachments +"]";
	}
}