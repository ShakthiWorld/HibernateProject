package com.visa.training.jpa.app;

import com.visa.training.jpa.dal.JpaAccountDAO;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.SavingsAccount;

public class AccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Account acc=new SavingsAccount(25000);
			JpaAccountDAO dao=new JpaAccountDAO();
			dao.save(acc);
			
			acc=new CurrentAccount(10000,50000);
			dao.save(acc);
			System.exit(0);
	
	}

}
