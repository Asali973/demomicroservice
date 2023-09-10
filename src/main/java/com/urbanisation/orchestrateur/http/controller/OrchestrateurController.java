package com.urbanisation.orchestrateur.http.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.urbanisation.orchestrateur.DTO.AssureDTO;
import com.urbanisation.orchestrateur.DTO.ContratDTO;
import com.urbanisation.orchestrateur.DTO.ProduitDTO;
import com.urbanisation.orchestrateur.proxy.AssureProxy;
import com.urbanisation.orchestrateur.proxy.ContratProxy;
import com.urbanisation.orchestrateur.proxy.ProduitProxy;

// class OrchestrateurControlle utilise des Api externes
// pas d'API @Rest..
@Controller
public class OrchestrateurController {

	@Autowired // injection
	private AssureProxy assureProxy;

	@Autowired
	private ContratProxy contratProxy;

	@Autowired
	private ProduitProxy produitProxy;

	// pour afficher la liste des assurrés
	@GetMapping(value = "/index")
	public String index(Model m) {// page acceuil

		Iterable<AssureDTO> listassuresDTO = assureProxy.getAllAssures();
		m.addAttribute("emeraud", listassuresDTO);// ma collection DTO qui s'appel liste et je mets dans mon model
		return "index";
	}

	// pour faire un formulaire pour rechercher un assuré
	@GetMapping("/formulaire")
	public String formulaire(Model m) {// page acceuil
		AssureDTO assureDTO = new AssureDTO();
		m.addAttribute("resultatrecherche", assureDTO);
		return "formulaire";
	}

	// méthode
	@PostMapping(value = "/saisir-assure")
	public String saisirAssure(AssureDTO assureDTO, Model model) {
		// log.info("---------------------------- Envoi requête vers saisirAssure");
		Iterable<AssureDTO> assures = assureProxy.getAssureNomPrenom(assureDTO.getNom(), assureDTO.getPrenom());
		model.addAttribute("assures", assures);
		return "ListeAssure";
	}


	// formulaire affecterNumeroProduit
	@GetMapping(value = "/affecterNumeroProduit/{numeroAssure}/{numeroProduit}")
	public String affecterNumeroProduit(@PathVariable Long numeroAssure, @PathVariable Long numeroProduit, Model m) {
		ContratDTO contratDTO =new ContratDTO();
		m.addAttribute("contratAssure", contratDTO);
		m.addAttribute("NumeroAssure", numeroAssure);
		m.addAttribute("numeroProduit", numeroProduit);
		return "affecterNumeroProduit";
	}
	
	@PostMapping(value = "/finaliser-contrat")
	public String finaliserContrat(ContratDTO contratDTO, Model model, @PathVariable LocalDate dateDebut) {
		// log.info("---------------------------- Envoi requête vers saisirAssure");
		Iterable<ContratDTO>contrats = contratProxy.getAllContrats();
		model.addAttribute("contrats", contrats);
		return "finaliser";
	}
	

//	@GetMapping(value = "/Contrat/{numeroAssure}")
//	public String creerContrat(@PathVariable Long numeroAssure, Model m) {
//	    
//	    ResponseEntity<Void> contratResponse = contratProxy.creerContrat(numeroAssure);
//
//	    // Vérifiez si la création du contrat a réussi
//	    if (contratResponse.getStatusCode().is2xxSuccessful()) {
//	        m.addAttribute("creerContrat", "Le contrat a été créé avec succès.");
//	    } else {
//	        m.addAttribute("creerContrat", "La création du contrat a échoué. Veuillez réessayer.");
//	    }
//	    Iterable<ProduitDTO> produits = produitProxy.getAllProduits();
//	    m.addAttribute("numeroAssure", numeroAssure);
//		m.addAttribute("produits", produits);
//	    
//	    return "contratAssure"; 
//	}
	@GetMapping(value = "/creerContrat/{numeroAssure}")
	public String creerContrat(@PathVariable Long numeroAssure, Model m) {
		// Use the ContratProxy to make a POST request to the external service
		ResponseEntity<Void> response = contratProxy.creerContrat(numeroAssure);

		if (response.getStatusCode() == HttpStatus.CREATED) {
			m.addAttribute("creerContrat", "Le contrat a été créé avec succès.");
		} else {
			m.addAttribute("creerContrat", "La création du contrat a échoué. Veuillez réessayer.");
		}
		Iterable<ProduitDTO> produits = produitProxy.getAllProduits();
		m.addAttribute("numeroAssure", numeroAssure);
		m.addAttribute("produits", produits);
		return "contratAssure";
	}

	// méthode pour saisir information de recherche
	@PostMapping(value = "/saisir-contrat")
	public String saisirContrat(ContratDTO contratDTO, Model model) {
		// log.info("---------------------------- Envoi requête vers saisirAssure");
		Optional<ContratDTO> contrats = contratProxy.getContratByNumeroAssure(contratDTO.getNumeroAssure());
		model.addAttribute("contrats", contrats);
		return "ListeContrat";
	}
	@GetMapping("/formulaireContrat")
	public String formulaireContrat(Model m) {// page acceuil
		ContratDTO contratDTO = new ContratDTO();
		m.addAttribute("resultatrechercheContrat", contratDTO);
		return "formulaireContrat";
	}

}