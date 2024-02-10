package com.codedecode.microservices.VaccinationCenter.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.codedecode.microservices.VaccinationCenter.Entity.VaccinationCenter;
@Service
public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
