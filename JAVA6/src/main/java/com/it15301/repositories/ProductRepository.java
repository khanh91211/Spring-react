package com.it15301.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.it15301.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT entity FROM Product entity WHERE category_id LIKE:category_id")
	public List<Product> findByCate(@Param("category_id") String sortField);
	
	@Query("SELECT entity FROM Product entity WHERE id LIKE:id")
	public Optional<Product> findById(Integer id);
	

}
