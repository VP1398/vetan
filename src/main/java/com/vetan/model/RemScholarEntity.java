package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_scholar")
public class RemScholarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="scholarship_type")
	private String scholarshipType;

	@Column(name="child_name")
	private String childName;
	
	@Column(name="relationship")
	private String relationship;

	@Column(name="financial_year")
	private String financialYear;
	
	@Column(name="college_name")
	private String collegeName;
	
	@Column(name="application_type")
	private String applicationType;

	@Column(name="passing_year")
	private String passingYear;
	
	@Column(name="percentage")
	private String percentage;
	
	@Column(name="amt")
	private String scholarshipAmount;

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

	public String getScholarshipType() {
		return scholarshipType;
	}

	public void setScholarshipType(String scholarshipType) {
		this.scholarshipType = scholarshipType;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getScholarshipAmount() {
		return scholarshipAmount;
	}

	public void setScholarshipAmount(String scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
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
		return "RemScholarEntity [id=" + id +", scholarshipType=" +scholarshipType +
				", childName=" + childName +", relationship=" + relationship + 
				 ", financialYear=" + financialYear   + ", collegeName=" + collegeName   +
	            ", applicationType=" + applicationType + ", passingYear=" + passingYear +
               ", percentage=" + percentage + ", scholarshipAmount="+scholarshipAmount+
				", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}