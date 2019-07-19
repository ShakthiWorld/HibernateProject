package com.visa.training.jpa.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	int id;
	String firstname,middlename,lastname;
	Date dateofjoin;
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	@ManyToMany(cascade =CascadeType.PERSIST)
	@JoinTable(name="customer_address",joinColumns = @JoinColumn(name="cust_id"),inverseJoinColumns = @JoinColumn(name="address_id"))
	List<Address> addresses=new ArrayList<Address>();
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	List<Account> accounts=new ArrayList<Account>();
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstname, String middlename, String lastname, Date dateofjoin) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dateofjoin = dateofjoin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(Date dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", dateofjoin=" + dateofjoin + "]";
	}
	
	
}

