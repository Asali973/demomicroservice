/**
 * 
 */
package com.urbanisation.orchestrateur.proxy;



import java.time.LocalDate;
import java.util.Optional;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urbanisation.orchestrateur.DTO.ContratDTO;










/**
 * @author Stagiaite
 *
 */
@FeignClient(name = "microservicecontrat",url="localhost:9996/previt")
public interface ContratProxy {
	
	// afficher la liste des contrats
	@GetMapping(path = "/listerLesContrats")
	public @ResponseBody Iterable<ContratDTO> getAllContrats();
	
	//rechercher un contrat grace au numero assuré
	
	@GetMapping(path = "/ContratNumeroAssure/{numeroAssure}")
	public @ResponseBody Optional<ContratDTO> getContratByNumeroAssure(@PathVariable Long numeroAssure);
	
	@GetMapping(path = "/creerContrat")
	ResponseEntity<Void> creerContrat(@RequestParam Long numeroAssure);

	@GetMapping(path = "/ContratNumeroProduit/{numeroProduit}")
	public @ResponseBody Optional<ContratDTO> getContratByNumeroProduit(@PathVariable Long numeroProduit);

	@GetMapping(path = "/ContratNumero/{numeroContrat}")
	public @ResponseBody Optional<ContratDTO> getContratByNumeroContrat(@PathVariable Long numeroContrat);
}