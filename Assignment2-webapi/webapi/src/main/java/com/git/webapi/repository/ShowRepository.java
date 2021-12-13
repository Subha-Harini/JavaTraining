package com.git.webapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.git.webapi.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {
	
	
	List<Show> findByType(String type);
	List<Show> findByType(String type, Pageable pageable);
	
	@Query(value="select * from `show` s where s.listed_in like %:movieType%", nativeQuery=true)
	List<Show> findAllHorrorMovies(@Param("movieType") String movieType);
	
	@Query(value="select * from `show` s where s.country like %:country%", nativeQuery=true)
	List<Show> findAllByCountry(@Param("country") String country);
}
