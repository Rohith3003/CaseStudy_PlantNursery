package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.bean.Plant;

public interface IPlantRepository extends JpaRepository<Plant, Integer> {
		//Get Seed by name
		@Query(value="select p from Plant p where p.name=:name")
		public Plant getByName(@Param("name") String name);
}
