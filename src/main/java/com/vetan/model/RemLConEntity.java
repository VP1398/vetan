package com.vetan.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rem_lcon")
public class RemLConEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="loc_con")
	private String localConveyance;

	@Column(name="purpose")
	private String purpose;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="start_time")
	private String startTime;
	
	@Column(name="end_time")
	private String endTime;

	@Column(name="frm")
	private String from;
	
	@Column(name="destination")
	private String destination;
	
	@Column(name="vehicle_type")
	private String vehicleType;

	@Column(name="transport_mode")
	private String transportMode;
	
	@Column(name="kms_no")
	private String kmsNo;
	
	@Column(name="rate")
	private String rate;
	
	@Column(name="amt")
	private double amount;
	
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
	
	public String getLocalConveyance() {
		return localConveyance;
	}

	public void setLocalConveyance(String localConveyance) {
		this.localConveyance = localConveyance;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public String getKmsNo() {
		return kmsNo;
	}

	public void setKmsNo(String kmsNo) {
		this.kmsNo = kmsNo;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
		return "RemLConEntity [id=" + id + ", localConveyance=" + localConveyance + 
		", purpose=" + purpose +",  date=" + date   + ",  startTime=" + startTime   +",  endTime=" + endTime   + 
		", from=" + from  + ",  destination=" + destination + 
		", vehicleType  =" + vehicleType   + ",  transportMode  =" +  transportMode   +
        ",  kmsNo   ="+  kmsNo   + ", rate="+ rate + ",amount=" + amount +
		", remarks=" + remarks +", attachments=" + attachments +"]";
	}
}