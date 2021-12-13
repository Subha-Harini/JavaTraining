package com.git.dataaccesslayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.git.dataaccesslayer.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

	@Query(value="select * from user s where s.username = :username", nativeQuery=true)
	User findByUsername(@Param("username") String username);
	
	@Query(value="select * from user s where s.id = :userId", nativeQuery=true)
	User findByUserId(@Param("userId") String userId);
}
