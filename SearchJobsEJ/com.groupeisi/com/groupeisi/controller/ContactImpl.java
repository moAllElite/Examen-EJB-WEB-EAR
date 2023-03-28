package com.groupeisi.controller;



import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.groupeisi.entities.Contact;
import com.groupeisi.entities.Cv;

@Stateless
public class ContactImpl implements IContactLocal, IContactRemote {
	@PersistenceContext(name = "searchjob")
	protected EntityManager en;

	@Override
	public int add(Contact contact) {
		// TODO Auto-generated method stub
		int ok=1;
		en.persist(contact);
		return ok;
	}

	@Override
	public int update(Contact contact) {
		int ok=1;
		en.merge(contact);
		return ok;
	}

	@Override
	public int delete(int id, Contact contact) {
		int ok=1;
		String table=Contact.class.getSimpleName();
		contact=(Contact) en.createQuery("SELECT c FROM "+table+"  c WHERE c.id=:id")
				.setParameter("id", id)
				.getSingleResult();
		 en.remove(contact);
		 return ok;
	}

	@Override
	public List<Contact> liste(Contact contact) {
		String table=Contact.class.getSimpleName();
	       return  en.createQuery("SELECT t FROM " + table + " t").getResultList();
	       
	}

	@Override
	public Contact get(int id, Contact contact) {
		String table=Contact.class.getSimpleName();
        contact=(Contact) en.createQuery("SELECT t FROM " + table + " t WHERE t.id=:id").setParameter("id", id).getSingleResult();
        return contact;
	}
	
}
