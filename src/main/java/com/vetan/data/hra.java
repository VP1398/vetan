package com.vetan.data;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "hra")

public class hra {
	@Id
	@Column(name = "id")
	private Long SlNo;
	@Column(name = "ecode")
	private String EmpCode;
	@Column(name = "ename")
	private String Name;
	@Column(name = "area")
	private String Department;
	@Column(name = "bcode")
	private Long Branch;
	@Column(name = "loan_type")
	private Date HRAType;
	@Column(name = "F")
	private Long Amount;
}