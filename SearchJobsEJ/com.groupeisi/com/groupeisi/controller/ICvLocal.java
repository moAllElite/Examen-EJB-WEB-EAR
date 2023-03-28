package com.groupeisi.controller;

import javax.ejb.Local;

import com.groupeisi.entities.Cv;

@Local
public interface ICvLocal  extends IRepository<Cv>{
	public Cv getCvByUserId(int user_id);
}
