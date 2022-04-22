package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="empr_lv")
public class EmprLvEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="ecode")
	private String ecode;

	@Column(name="ename")
	private String ename;

	@Column(name="cat")
	private String category;

	@Column(name="role")
	private String role;

	@Column(name="doj")
	private Date dateOfJoining;

	@Column(name="age")
	private String age;

	@Column(name="loc")
	private String location;

	@Column(name="dept")
	private String department;

	@Column(name="bcode")
	private String bcode;

	@Column(name="gen")
	private String gender;
	
	@Column(name="manager")
	private String manager;

	@Column(name="city_type")
	private String cityType;
	
	@Column(name="leave_type")
	private String leaveType;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="no_of_days")
	private String noOfDays;
	
	@Column(name="days")
	private String days;

	
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
	
	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
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

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
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
		return "EmprLvEntity [id=" + id + ", ecode=" + ecode +
				", ename=" + ename + ", category=" + category   +
				", role=" + role   + ", dateOfJoining=" + dateOfJoining   +
				", age=" + age   + ", location=" + location   +
				", department=" + department   + ", bcode=" + bcode   +
				", gender=" + gender   + ", manager=" + manager   +
				", cityType=" + cityType   + ", leaveType=" + leaveType   + 
				", startDate=" + startDate +", endDate=" + endDate   + ", days=" + days   +
				", noOfDays=" + noOfDays   + ", status=" + status   +
				", attachments=" + attachments +"]";
	}
}