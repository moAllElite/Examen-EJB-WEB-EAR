package com.groupeisi.controller;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Cv;
@Stateless
public class CvImpl	implements ICvLocal, ICvRemote {
	@PersistenceContext(name = "searchjob")
	protected EntityManager en;
	@Override
	public int add(Cv cv) {
		int ok=1;
		en.persist(cv);
		return ok;
	}

	@Override
	public int update(Cv cv) {
		int ok=1;
		en.merge(cv);
		return ok;
	}

	@Override
	public int delete(int id, Cv cv) {
		int ok=1;
		String table=Cv.class.getSimpleName();
		cv= (Cv) en.createQuery("SELECT c FROM "+table+"	c WHERE c.id=:id")
				.setParameter("id", id)
				.getSingleResult();
		 en.remove(cv);
		 return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cv> liste(Cv cv) {
		String table=Cv.class.getSimpleName();
	       return  en.createQuery("SELECT t FROM " + table + " t").getResultList();
	}
	

	@Override
	public Cv get(int id, Cv cv) {
			String table=Cv.class.getSimpleName();
			cv=(Cv) en.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
	        return cv;     
	}

	@Override
	public Cv getCvByUserId(int user_id) {
		return (Cv) en.createQuery(" SELECT c FROM Cv c WHERE c.user.id = :user_id")
				.setParameter("user_id", user_id)
				.getSingleResult();
	}

	


}
