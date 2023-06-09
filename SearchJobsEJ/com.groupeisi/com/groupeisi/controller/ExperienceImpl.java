package com.groupeisi.controller;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;
@Stateless
public class ExperienceImpl	 implements IExperienceLocal, IExperienceRemote {
	@PersistenceContext(name = "searchjob")
	protected EntityManager en;

	@Override
	public int add(Experience experience) {
		int ok=1;
		en.persist(experience);
		return ok;
	}

	@Override
	public int update(Experience experience) {
		int ok=1;
		en.merge(experience);
		return ok;
	}
	@Override
	public int delete(int id, Experience experience) {
		int ok=1;
		String table=Experience.class.getSimpleName();
		 experience=(Experience) en.createQuery("SELECT e FROM "+table+" e WHERE e.id=:id")
				 .setParameter("id", id)
				 .getSingleResult();
		 en.remove(experience);
		 return ok;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> liste(Experience experience) {
		String table=Experience.class.getSimpleName();
		Query query= en.createQuery("SELECT t FROM " + table + " t");
	       return query.getResultList();
	      
	}

	@Override
	public Experience get(int id, Experience experience) {
		String table=Experience.class.getSimpleName();
        experience=(Experience) en.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        return experience;
        }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Experience> getExperiencesByCvId(int cv_id) {
		TypedQuery<Experience> query = en.createQuery(
		        "SELECT e FROM Cv c JOIN c.experiences e WHERE c.id = :cv_id", 
		        Experience.class);
		    query.setParameter("cv_id", cv_id);
		    return query.getResultList();
	}

	
	
}
