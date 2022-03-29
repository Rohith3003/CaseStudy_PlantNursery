package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.Fertilizer;

/**
 * This interface acts as repository which communicates with database and
 * executes all the queries coming from FertilizerService to database
 * 
 * @author Rohith(Employee id: 46191986)
 */
@Repository
public interface IFertilizerRepository extends JpaRepository<Fertilizer, Integer> {

	/**
	 * Retrieves the fertilizer of given name from database.
	 * 
	 * @param name
	 * @return Returns the fertilizer of given name.
	 */
	public Fertilizer findByFertilizerName(String name);

	/**
	 * Retrieves the fertilizer of given name from database.
	 * 
	 * @param name
	 * @return returns the fertilizer of given name.
	 */
	@Query(value = "delete from fertilizer where name=:name", nativeQuery = true)
	public void deleteByName(@Param("name") String name);

}
