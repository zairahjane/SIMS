package com.sims.domain;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedicationRepo extends PagingAndSortingRepository<Medication, Long>{
	
	Page<Medication> findByMedicationDate(Date medicationDate, Pageable pageable);
	Page<Medication> findByMedicationType(String medicationType, Pageable pageable);
	Page<Medication> findByMedicationAmount(Double medicationAmount, Pageable pageable);

}
