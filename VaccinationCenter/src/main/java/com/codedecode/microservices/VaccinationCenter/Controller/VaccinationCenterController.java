package com.codedecode.microservices.VaccinationCenter.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codedecode.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.codedecode.microservices.VaccinationCenter.Model.Citizen;
import com.codedecode.microservices.VaccinationCenter.Model.Responsedto;
import com.codedecode.microservices.VaccinationCenter.Repo.CenterRepo;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter center){
		VaccinationCenter centeradded = centerRepo.save(center);
		return new ResponseEntity<>(centeradded,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Responsedto> getData(@PathVariable Integer id){
		Responsedto response = new Responsedto();
		//Get Vaccination center details
		VaccinationCenter center = centerRepo.findById(id).get();
		response.setCenter(center);
		
		//get citizen details registered to vaccinationcenterid
		
		//List<Citizen> citizen =restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
		List<Citizen> citizen =restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);//will search url for citizen service from eureka server. Used @Loadbalanced at bean
		response.setCitizens(citizen);
		return new ResponseEntity<Responsedto>(response,HttpStatus.OK);
		
	}
}
