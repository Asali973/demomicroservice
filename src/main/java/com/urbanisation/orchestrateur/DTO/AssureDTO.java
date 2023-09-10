/**
 * 
 */
package com.urbanisation.orchestrateur.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Stagiaite
 *faire dtoproduit et contrat 
 *proxy un pattern c'est un speudo objet 
 *architecture distrubué communication entre 2 programmes complements différents 
 */
public class AssureDTO {

	private Long numeroAssure;
	private String nom;
	private String Prenom;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateNaissance;
	
	//getters/setters
	public Long getNumeroAssure() {
		return numeroAssure;
	}
	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
}
