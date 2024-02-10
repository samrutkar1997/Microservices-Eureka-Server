package com.codedecode.microservices.CitizenService.Repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codedecode.microservices.CitizenService.Entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen,Integer>{
	public List<Citizen> findByVaccinationCenterId(Integer Id);
}
