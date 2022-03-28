package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.bean.Planter;

public interface IPlanterRepository extends JpaRepository<Planter, Integer> {
	
	//Get Planter by name
	@Query(value="select p from Planter p where p.name=:name")
	public Planter getByName(@Param("name") String name);
	
	@Query(value = "delete from planter where name=:name returning *", nativeQuery = true)
	public Planter deleteByName(@Param("name") String name);
}
