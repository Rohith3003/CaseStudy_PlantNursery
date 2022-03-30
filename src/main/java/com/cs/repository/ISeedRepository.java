package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.Seed;
/**
 * Repository interface extending JPARepository for Planter entity, 
 * that interacts with database. 
 * @author Palak
 *
 */
@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer> {
	
	//Get Seed by name
	/**
	 * Get seed by name
	 * @param name
	 * @return seed
	 */
	@Query(value="select p from Seed p where p.name=:name")
	public Seed getByName(@Param("name") String name);
}
