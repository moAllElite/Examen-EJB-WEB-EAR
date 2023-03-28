package com.groupeisi.controller;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Formation;

@Local
public interface IFormationLocal extends IRepository<Formation> {
	public List<Formation> getFormationByIdCv(int cv_id);
}
