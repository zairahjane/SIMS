package com.sims.domain;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BreedingRepo extends PagingAndSortingRepository<Breeding, Long>{
	
	Page<Breeding> findByBreedingDate(Date breedingDate, Pageable pageable);
	Page<Breeding> findByPigletCount(Long pigletCount, Pageable pageable);

}
