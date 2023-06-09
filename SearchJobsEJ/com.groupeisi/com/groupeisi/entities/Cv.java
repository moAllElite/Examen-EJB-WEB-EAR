package com.groupeisi.entities;
import com.groupeisi.entities.Experience;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Cv  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String skills;
	private String interets;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id")
	private Contact contact;
	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences=new ArrayList<Experience>();
	@OneToMany(mappedBy = "cv")
	private List<Formation> formations=new ArrayList<Formation>();
	/**
	 * constructor par défaut
	 */
	public Cv() {
	
	}
	
	public Cv(int id, String nom, String prenom, String skills, String interets, User user, Contact contact,
			List<Experience> experiences, List<Formation> formations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.skills = skills;
		this.interets = interets;
		this.user = user;
		this.contact = contact;
		this.experiences = experiences;
		this.formations = formations;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @return the interets
	 */
	public String getInterets() {
		return interets;
	}

	/**
	 * @param interets the interets to set
	 */
	public void setInterets(String interets) {
		this.interets = interets;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}
	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the experiences
	 */
	public List<Experience> getExperiences() {
		return experiences;
	}
	/**
	 * @param experiences the experiences to set
	 */
	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
	/**
	 * @return the formations
	 */
	public List<Formation> getFormations() {
		return formations;
	}
	/**
	 * @param formations the formations to set
	 */
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	
	
	

	
}
