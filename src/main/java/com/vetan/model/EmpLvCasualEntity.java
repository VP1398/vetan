package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Emp_lv_Casual")
public class EmpLvCasualEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="leave_type")
	private String leaveType;

	@Column(name="opening_balance")
	private double openingBalance;

	@Column(name="credit")
	private double credit;

	@Column(name="total")
	private double total;

	@Column(name="availed")
	private double availed;

	@Column(name="balance")
	private double balance;

	@Column(name="application_date")
	private Date applicationDate;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="days")
	private String days;

	@Column(name="no_of_days")
	private String noOfDays;

	@Column(name="note_for_approver")
	private String noteForApprover;

	@Column(name="status")
	private String status;
	
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

	
	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getAvailed() {
		return availed;
	}

	public void setAvailed(double availed) {
		this.availed = availed;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getNoteForApprover() {
		return noteForApprover;
	}

	public void setNoteForApprover(String noteForApprover) {
		this.noteForApprover = noteForApprover;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	     return "EmpLvCasualEntity [id=" + id + ", leaveType=" + leaveType +
			", openingBalance=" + openingBalance + ", credit=" + credit   +
			", total=" + total   + ", availed=" + availed   +
			", balance=" + balance   + ", applicationDate=" + applicationDate   +
			", startDate=" + startDate   + ", endDate=" + endDate   + ", days=" + days   +
			", noOfDays=" + noOfDays +", noteForApprover=" + noteForApprover + ", status=" +status + ", attachments=" + attachments +"]";
}
}