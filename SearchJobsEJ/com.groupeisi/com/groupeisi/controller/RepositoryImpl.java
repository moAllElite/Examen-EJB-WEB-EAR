package com.groupeisi.controller;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class RepositoryImpl<T> implements IRepository<T> {
	@PersistenceContext(name = "searchjob")
	protected EntityManager en;
	private static final long serialVersionUID = 1L;
	
	@Override
	public int add(T t) {
		// TODO Auto-generated method stub
		int ok=1;
		en.persist(t);
		return ok;
	}
	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		int ok=1;
		en.merge(t);
		return ok;
	}
	
	@Override
	public List<T> liste(T t) {
		// TODO Auto-generated method stub
		String table=t.getClass().getSimpleName();
		return en.createQuery("SELECT t FROM"+table).getResultList();
	}
	@Override
	public T get(int id, T t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(int id, T t) {
		int ok=1;
		String table=t.getClass().getSimpleName();
		t=(T) en.createQuery("SELECT t FROM"+table+"WHERE id=:id").setParameter("id", id).getSingleResult();
		return ok;
	}

}
