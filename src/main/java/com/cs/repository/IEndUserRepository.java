package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.bean.EndUser;

public interface IEndUserRepository extends JpaRepository<EndUser, Integer>{

}
