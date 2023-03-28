package com.groupeisi.controller;

import java.util.List;

import javax.ejb.Local;

import com.groupeisi.entities.Cv;
import com.groupeisi.entities.Experience;

@Local
public interface IExperienceLocal extends IRepository<Experience>{
		public List<Experience>getExperiencesByCvId(int cv_id);
}	
