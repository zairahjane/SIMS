package com.sims.domain;

import java.sql.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SwineRepo extends PagingAndSortingRepository<Swine, Long>{

	Page<Swine> findByTypeStartingWith(String type, Pageable pageable);
	Page<Swine> findByBreedStartingWith(String breed, Pageable pageable);
	Page<Swine> findByGenderStartingWith(String gender, Pageable pageable);
	Page<Swine> findByBdayStartingWith(Date bday, Pageable pageable);
}
