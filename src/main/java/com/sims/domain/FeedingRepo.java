package com.sims.domain;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FeedingRepo extends PagingAndSortingRepository<Feeding, Long>{
	
	Page<Feeding> findByFeedingDate(Date feedingDate, Pageable pageable);
	Page<Feeding> findByFeedingTime(Time feedingTime, Pageable pageable);
	Page<Feeding> findByFoodType(String foodType, Pageable pageable);
	Page<Feeding> findByFoodAmount(Double foodAmount, Pageable pageable);

}
