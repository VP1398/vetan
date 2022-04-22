package com.vetan.message;

public class ResponseFile {
	private String name;
	private String url;
	private String type;
	private long size;
	private String expense;
	private String vendor;
	private String inv_no;
	private String inv_date; 
	private String inv_amt;
    private String ent_amt;
	private String claimed_amt;
	private String remarks;
	private String id;
	private byte[] data;


	public ResponseFile(String name, String url, String type, long size) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}

	public ResponseFile(String name, String url, String type, int size, 
			 String expense, String vendor,
				String inv_no, String inv_date, String inv_amt,  String ent_amt,  String claimed_amt, String remarks, String id) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
		this.expense= expense;
		this.vendor=vendor;
		this.inv_no = inv_no;
		this.inv_date = inv_date;
		this.inv_amt = inv_amt;
		this.ent_amt = ent_amt;
		this.claimed_amt = claimed_amt;
		this.remarks = remarks;
		this.id = id;
	}

	public ResponseFile(String name, String url, String type, int size,  String expense, String vendor,
			String inv_no, String inv_date, String inv_amt,  String ent_amt,  String claimed_amt, String remarks,
			 String id, byte[] data) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
		this.expense= expense;
		this.vendor=vendor;
		this.inv_no = inv_no;
		this.inv_date = inv_date;
		this.inv_amt = inv_amt;
		this.ent_amt = ent_amt;
		this.claimed_amt = claimed_amt;
		this.remarks = remarks;
		this.id = id;
		this.data=data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	
	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getInv_no() {
		return inv_no;
	}

	public void setInv_no(String inv_no) {
		this.inv_no = inv_no;
	}

	public String getInv_date() {
		return inv_date;
	}

	public void setInv_date(String inv_date) {
		this.inv_date = inv_date;
	}

	public String getInv_amt() {
		return inv_amt;
	}

	public void setInv_amt(String inv_amt) {
		this.inv_amt = inv_amt;
	}

	public String getEnt_amt() {
		return ent_amt;
	}

	public void setEnt_amt(String ent_amt) {
		this.ent_amt = ent_amt;
	}

	public String getClaimed_amt() {
		return claimed_amt;
	}

	public void setClaimed_amt(String claimed_amt) {
		this.claimed_amt = claimed_amt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
