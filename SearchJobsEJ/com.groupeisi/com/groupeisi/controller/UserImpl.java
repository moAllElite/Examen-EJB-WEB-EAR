package com.groupeisi.controller;

import com.groupeisi.entities.User;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
@Stateless
public class UserImpl 	implements IUserLocal, IUserRemote {
	@PersistenceContext(name = "searchjob")
	private EntityManager en;

	@Override
	public User getConnection(String email,String password) throws NoResultException {
		try {
			return (User) en.createQuery("SELECT u FROM User u WHERE email=:email AND password=:password")
				.setParameter("email", email)
				.setParameter("password", password)
				.getSingleResult();
		}catch (NoResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
			 return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			return	(User) en.createQuery("SELECT u FROM User u  WHERE u.email=:email")
				.setParameter("email", email)
				.getSingleResult();	
		}catch (NoResultException  e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getMessage();
			 return null;
		}
	}

	@Override
	public int add(User t) {
		int ok=1;
		en.persist(t);
		return ok;
	}

	@Override
	public int update(User t) {
		int ok=1;
		en.merge(t);
		return ok;
	}

	@Override
	public int delete(int id, User t) {
		int ok=1;
		en.remove(t);
		return ok;
	}

	@Override
	public List<User> liste(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id, User user) {
		// TODO Auto-generated method stub
		String table=User.class.getSimpleName();
		return (User) en.createQuery("SELECT u FROM "+table+"	u WHERE u.id=:id")
				.setParameter("id",id)
				.getSingleResult();
	}

	
}
