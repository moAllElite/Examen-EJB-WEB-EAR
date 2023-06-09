package com.groupeisi.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Formation;
@Stateless
public class FormationImpl implements IFormationLocal, IFormationRemote {
	@PersistenceContext(name = "searchjob")
	protected EntityManager en;

	@Override
	public int add(Formation formation) {
		int ok=1;
		en.persist(formation);
		return ok;
	}

	@Override
	public int update(Formation formation) {
		int ok=1;
		en.merge(formation);
		return ok;
	}

	@Override
	public int delete(int id, Formation formation) {
		int ok=1;
		String table=Formation.class.getSimpleName();
		 formation=(Formation) en.createQuery("SELECT f FROM "+table+" f WHERE f.id=:id")
				 .setParameter("id", id)
				 .getSingleResult();
		 en.remove(formation);
		 return 1;
	}

	@Override
	public List<Formation> liste(Formation formation) {
		String table=Formation.class.getSimpleName();
	       return  en.createQuery("SELECT t FROM " + table + " t").getResultList();
	       
	}

	@Override
	public Formation get(int id, Formation formation) {
		String table=Formation.class.getSimpleName();
        formation=(Formation) en.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        return formation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formation> getFormationByIdCv(int cv_id) {
		TypedQuery<Formation> query=(TypedQuery<Formation>) en
				.createQuery("SELECT f FROM Cv c JOIN c.formations f WHERE c.id=:cv_id"
						,Formation.class)
				.setParameter("cv_id", cv_id);
		return query.getResultList();
	}
}
