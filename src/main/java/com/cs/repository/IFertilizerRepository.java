package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.Fertilizer;

@Repository
public interface IFertilizerRepository extends JpaRepository<Fertilizer, Integer> {

	public Fertilizer findByFertilizerName(String name);

	@Query(value = "delete from fertilizer where name=:name returning *", nativeQuery = true)
	public Fertilizer deleteByName(@Param("name") String name);

}
