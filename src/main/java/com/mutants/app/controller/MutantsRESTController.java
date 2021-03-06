package com.mutants.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.app.domain.exception.DNAException;
import com.mutants.app.domain.wrappers.SymmetricDNA;
import com.mutants.app.resource.DNARequest;
import com.mutants.app.service.MutantDetectorService;
import com.mutants.app.validator.SymmetricDNAValidator;


@RestController
public class MutantsRESTController {

	@Autowired
	private SymmetricDNAValidator dnaValidator;
	
	@Autowired
	private MutantDetectorService mutantsDetector;
	
	@PostMapping(path="/mutant", consumes="application/json")
	public ResponseEntity<?> mutant(@RequestBody DNARequest dna) throws DNAException{
		//Validate DNA sequence
		dnaValidator.validate(dna);
		
		//Wrap DNA sequence
		SymmetricDNA dnaSequence = new SymmetricDNA(dna.getDna());
		
		//Check if is mutant
		boolean isMutant = mutantsDetector.isMutant(dnaSequence);
		
		//Reponse
		return ResponseEntity.status(isMutant? HttpStatus.OK : HttpStatus.FORBIDDEN).build();
	}

}