package com.groupeisi.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@Column(unique = true)
	private String email;
	@Column(nullable = false,length = 32)
	private String password;
	@OneToOne(mappedBy = "user",fetch = FetchType.EAGER )
	private Cv person;
	
	/**
	 * constructor par défaut
	 */
	public User() {
		super();
	}
	/**
	 * construtor
	 * @param id
	 * @param email
	 * @param person
	 * @param password
	 */
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public Cv getPerson() {
		return person;
	}
	public void setPerson(Cv person) {
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
