package com.visa.training.jpa.dal;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.visa.training.jpa.domain.Product;

public class JpaProductDAO {

	public Product save(Product p)
	{
		EntityManagerFactory emf=JpaUtil.getEmf();
		EntityManager em=emf.createEntityManager();
		try
		{
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Product> findAll()
	{
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		Query q=em.createQuery("select p from Product as p");
		List<Product>all=q.getResultList();
		
		
		em.close();
		return all;
	}
	public List<Product> findByPriceGreaterThan(float price)
	{
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		Query u=em.createQuery("select p from Product as p where p.price>:prize");
		u.setParameter("prize", price);
		List<Product> all=u.getResultList();
		em.close();
		return all;
	}
	
	public Product findById(int id)
	{
		Product p=null;
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		try {
		p=em.find(Product.class,id);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			
		}
		return p;
	
	}
	public void remove(int id)
	{
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		Product p=em.find(Product.class,id);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		if(p!=null)
		em.remove(p);
		tx.commit();
		em.close();
		
	}
	public void update(Product p)
	{
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(p);
		tx.commit();
		em.close();
	}
	
}
