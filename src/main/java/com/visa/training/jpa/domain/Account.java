package com.visa.training.jpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.Table;

@Entity
@Table(name="account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="acct_type",discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	float balance;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cust_id")
	Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(float balance) {
		super();
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
