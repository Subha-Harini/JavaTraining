package com.git.dataaccesslayer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.git.dataaccesslayer.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

	@Query(nativeQuery = true, value = "select max(b_id) from bill;")
	int findMaximunBillId();
}
