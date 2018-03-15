package com.sims.domain;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WeightRepo extends PagingAndSortingRepository<Weight, Long>{
	
	Page<Weight> findByWeightDate(Date weightDate, Pageable pageable);
	Page<Weight> findByWeight(Double weight, Pageable pageable);

}
