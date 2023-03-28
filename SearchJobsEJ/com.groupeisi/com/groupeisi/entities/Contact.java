package com.groupeisi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Contact implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String telephoneSpecialite;
	@OneToOne(mappedBy = "contact",fetch = FetchType.EAGER)
	private Cv cv;
	
	public Contact() {
		super();
	}

	public Contact(int id, String adresse, String telephoneSpecialite) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.telephoneSpecialite = telephoneSpecialite;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephoneSpecialite() {
		return telephoneSpecialite;
	}

	public void setTelephoneSpecialite(String telephoneSpecialite) {
		this.telephoneSpecialite = telephoneSpecialite;
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

	
	
}
