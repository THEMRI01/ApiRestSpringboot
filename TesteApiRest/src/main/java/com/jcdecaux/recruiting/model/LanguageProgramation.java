package com.jcdecaux.recruiting.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="languageprogramtion")
@EntityListeners(AuditingEntityListener.class) 
public class LanguageProgramation {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id ; 

	@NotBlank
	private String nom ; 
	@NotBlank
	private String version ;

	@ManyToOne
	@JoinColumn(name = "iddev")
	private Developpeur developpeur;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}





}
