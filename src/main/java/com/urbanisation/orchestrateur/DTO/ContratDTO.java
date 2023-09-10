/**
 * 
 */
package com.urbanisation.orchestrateur.DTO;

import java.time.LocalDate;

/**
 * @author Stagiaite
 *
 */
public class ContratDTO {
	
	
	private LocalDate dateDebut;
	private Long numeroContrat;
	private Long numeroAssure;
	private Long numeroProduit;
	
	
	// GETTERS/SETTERS
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Long getNumeroContrat() {
		return numeroContrat;
	}
	public void setNumeroContrat(Long numeroContrat) {
		this.numeroContrat = numeroContrat;
	}
	public Long getNumeroAssure() {
		return numeroAssure;
	}
	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}
	public Long getNumeroProduit() {
		return numeroProduit;
	}
	public void setNumeroProduit(Long numeroProduit) {
		this.numeroProduit = numeroProduit;
	}
	
	
	
	
}
