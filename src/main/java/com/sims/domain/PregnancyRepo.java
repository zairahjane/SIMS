package com.sims.domain;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PregnancyRepo extends PagingAndSortingRepository<Pregnancy, Long>{
	
	Page<Pregnancy> findByPregnancyDate(Date weightDate, Pageable pageable);

}
