package com.git.dataaccesslayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM cart c where c.User_id = :userId and c.Product_id= :prdId")
	Cart findByUserAndProduct(@Param("userId") String userId, @Param("prdId") int prdId);
}
