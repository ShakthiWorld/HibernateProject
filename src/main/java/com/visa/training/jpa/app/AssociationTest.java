package com.visa.training.jpa.app;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.Address;
import com.visa.training.jpa.domain.Customer;
import com.visa.training.jpa.domain.SavingsAccount;

public class AssociationTest {

	public static void main(String[] args) {
		
//		createAccountAndCustomerSeparately();
//		readAccountAlongWithCustomer();
		/*
		 * createAccountAndCustomerTogether(); 
		 * testLazy();
		 */
		testManyToMany();
		
		System.exit(0);
	}

	private static void testManyToMany() {
		// TODO Auto-generated method stub
		
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		Customer cust=new Customer("xyz", "abc","ghbv",new Date(System.currentTimeMillis()));
		Address a=new Address("a","b","c","d","e","f");
		cust.getAddresses().add(a);
		em.persist(cust);
		
		tx.commit();
		em.close();
		
	}

	private static void testLazy() {
		// TODO Auto-generated method stub
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		Customer c1=em.find(Customer.class, 41);
		em.close();
		
		System.out.println(c1.getFirstname());
		Account a=c1.getAccounts().get(0);
		System.out.println(a.getBalance());
		
		
		
	}

	private static void createAccountAndCustomerTogether() {
		
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		Customer c=new Customer("abc","def","ghi",new Date(System.currentTimeMillis()));
		Account ac=new SavingsAccount(200);
		ac.setCustomer(c);
//		em.persist(c);
		em.persist(ac);
		
		
		tx.commit();
		em.close();
	}

	private static void readAccountAlongWithCustomer() {
		// TODO Auto-generated method stub
		
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		
		SavingsAccount sa=em.find(SavingsAccount.class,38 );
		
		
	}

	private static void createAccountAndCustomerSeparately() {
		
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		Customer c=new Customer("abc","def","ghi",new Date(System.currentTimeMillis()));
		Account ac=new SavingsAccount(200);
		ac.setCustomer(c);
		em.persist(c);
		em.persist(ac);
		
		ac=new SavingsAccount(300);
		ac.setCustomer(c);
		em.persist(ac);
		tx.commit();
		em.close();
		
		
		
	}

}
