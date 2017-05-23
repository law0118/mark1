package com.mark1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mark1.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findById(long id);
	
	@Query("SELECT lg FROM Category lg WHERE lg.name LIKE %?1%")
	List<Category> findByName(String name);
}