package com.groupeisi.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Experience implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private	String societe;
	private String datedb;
	private String datefn;
	private String poste;
	private String ville;
	@ManyToOne(fetch = FetchType.EAGER )
	  
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	public Experience() {
	
	}
	
	public Experience(int id, String societe, String datedb, String datefn, String poste, String ville, Cv cv) {
		super();
		this.id = id;
		this.societe = societe;
		this.datedb = datedb;
		this.datefn = datefn;
		this.poste = poste;
		this.ville = ville;
		this.cv = cv;
	}

	/**
	 * getters setters
	 * @return
	 */
	
	public int getId() {
		return id;
	}
	/**
	 * @return the cv
	 */
	public Cv getCv() {
		return cv;
	}
	/**
	 * @param cv the cv to set
	 */
	public void setCv(Cv cv) {
		this.cv = cv;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	
	/**
	 * @return the datedb
	 */
	
	public String getPoste() {
		return poste;
	}
	/**
	 * @return the datedb
	 */
	public String getDatedb() {
		return datedb;
	}
	/**
	 * @param datedb the datedb to set
	 */
	public void setDatedb(String datedb) {
		this.datedb = datedb;
	}
	/**
	 * @return the datefn
	 */
	public String getDatefn() {
		return datefn;
	}
	/**
	 * @param datefn the datefn to set
	 */
	public void setDatefn(String datefn) {
		this.datefn = datefn;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
