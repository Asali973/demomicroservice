package com.urbanisation.orchestrateur.proxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urbanisation.orchestrateur.DTO.AssureDTO;


/**
 * @author Stagiaite
 *
 */
@FeignClient(name = "microserviceassure",url="localhost:9999/previt")// on veut appeler notre API assure
public interface AssureProxy {
	
// exemple recherche sur le nom prenom
	@GetMapping(path = "/assuresNomPrenom/{nom}/{prenom}")
    public @ResponseBody Iterable<AssureDTO> getAssureNomPrenom(@PathVariable String nom, @PathVariable String prenom);
 
//afficher la liste des assurés
	@GetMapping(path = "/listerLesAssures")
	public @ResponseBody Iterable<AssureDTO> getAllAssures();
		
}
