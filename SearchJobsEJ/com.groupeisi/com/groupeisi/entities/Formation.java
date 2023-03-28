package com.groupeisi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Formation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ecole;
	private String annee;
	private String niveauEtude;
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	public Formation() {
	
	}

	
	public Formation(int id, String ecole, String annee, String niveauEtude, Cv cv) {
		super();
		this.id = id;
		this.ecole = ecole;
		this.annee = annee;
		this.niveauEtude = niveauEtude;
		this.cv = cv;
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ecole
	 */
	public String getEcole() {
		return ecole;
	}

	/**
	 * @param ecole the ecole to set
	 */
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	/**
	 * @return the annee
	 */
	public String getAnnee() {
		return annee;
	}

	/**
	 * @param annee the annee to set
	 */
	public void setAnnee(String annee) {
		this.annee = annee;
	}

	/**
	 * @return the diplome
	 */
	public String getNiveauEtude() {
		return niveauEtude;
	}

	/**
	 * @param diplome the diplome to set
	 */
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	
}
