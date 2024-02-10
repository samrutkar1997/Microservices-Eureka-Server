package com.codedecode.microservices.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.codedecode.microservices.CitizenService.Entity.Citizen;
import com.codedecode.microservices.CitizenService.Repositeries.CitizenRepository;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenRepository citizenrepo;
	
	@RequestMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("hello",HttpStatus.OK);
		
	}
	
	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id){
		List<Citizen> listcitizen = citizenrepo.findByVaccinationCenterId(id);
		
		return new ResponseEntity<>(listcitizen,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen){
		System.out.println(newCitizen.toString());
		System.out.println("hello");
		Citizen citizen= citizenrepo.save(newCitizen);
		return new ResponseEntity<>(citizen,HttpStatus.OK);
	}
	
	
}
