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
 * @version 1.0.0
 * @since 28-03-2022
 *
 */
@Repository
public interface IFertilizerRepository extends JpaRepository<Fertilizer, Integer> {

	public Fertilizer findByFertilizerName(String name);

	@Query(value = "delete from fertilizer where name=:name returning *", nativeQuery = true)
	public Fertilizer deleteByName(@Param("name") String name);

}
