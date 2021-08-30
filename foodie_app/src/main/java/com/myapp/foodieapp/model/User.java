package com.myapp.foodieapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.myapp.foodieapp.enums.UserProfileEnums;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name")
	private String customerName;
	private String email, mobile, password;
	
//	@Enumerated(EnumType.ORDINAL)
	@Column(name="account_inactive")
	private int accountStatus;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="created_at")
//	@CreatedDate
	private Date createdAt;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="updated_at")
//	@LastModifiedDate
	private Date updatedAt;

	//Default constructor
	public User() {}

	public User(int id, String customerName, String email, String mobile, String password) {
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public UserProfileEnums getAccountStatus() {
		return accountStatus == 0 ? UserProfileEnums.ACTIVE : UserProfileEnums.INACTIVE;
	}
	
	public void setAccountStatus(UserProfileEnums accountStatus) {
		this.accountStatus = accountStatus.equals(UserProfileEnums.ACTIVE) ? 0 : 1;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}

}
