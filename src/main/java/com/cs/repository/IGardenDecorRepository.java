package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.bean.GardenDecor;

@Repository
public interface IGardenDecorRepository extends JpaRepository<GardenDecor, Integer> {

}
