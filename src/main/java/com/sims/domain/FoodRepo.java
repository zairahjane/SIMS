package com.sims.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodRepo extends PagingAndSortingRepository<Food, Long>{

	Page<Food> findByProdnameStartingWith(String prodname, Pageable pageable);
	Page<Food> findByClassificationStartingWith(String classification, Pageable pageable);
	Page<Food> findByQuantityStartingWith(String quantity, Pageable pageable);
	Page<Food> findByWeightStartingWith(String weight, Pageable pageable);
	Page<Food> findByExpdateStartingWith(String expdate, Pageable pageable);
}
