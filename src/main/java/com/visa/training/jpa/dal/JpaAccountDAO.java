package com.visa.training.jpa.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.domain.Account;

public class JpaAccountDAO {

	public void save(Account acc)
	{
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(acc);
		tx.commit();
		em.close();
		
	}
	
}
