package com.sims.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MedicineRepo extends PagingAndSortingRepository<Medicine, Long>{

	Page<Medicine> findByTypeStartingWith(String type, Pageable pageable);
	Page<Medicine> findByNameStartingWith(String name, Pageable pageable);
	Page<Medicine> findByQuantityStartingWith(String quantity, Pageable pageable);
	Page<Medicine> findByExpdateStartingWith(String expdate, Pageable pageable);
}
