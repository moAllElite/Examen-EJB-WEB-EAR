package com.groupeisi.controller;


import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.User;

@Local
public interface IUserLocal extends IRepository<User> {
	public User getConnection(String email,String password);
	public User getUserByEmail(String email);
}
