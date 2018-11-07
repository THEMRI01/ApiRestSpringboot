package com.jcdecaux.recruiting.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="developpeurs")
@EntityListeners(AuditingEntityListener.class) 
public class Developpeur {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id ; 

	@NotBlank
	private String nom ; 
	@NotBlank
	private String prenom ;
	@NotBlank
	private String entreprise ;

	@OneToMany(mappedBy="developpeur", cascade=CascadeType.ALL)
	private Set<LanguageProgramation> languages;



	public Developpeur(String nom, String prenom, String entreprise) {
		// TODO Auto-generated constructor stub
	}
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}







}
