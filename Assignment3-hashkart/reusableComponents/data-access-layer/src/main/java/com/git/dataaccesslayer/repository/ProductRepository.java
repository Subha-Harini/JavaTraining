package com.git.dataaccesslayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY price_per_quantity ASC;")
	List<Product> getSortByPrice();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY rating ASC;")
	List<Product> getSortByRating();
}
