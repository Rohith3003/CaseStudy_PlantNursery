package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.EndUser;

@Repository
public interface ICustomerRepository extends JpaRepository<EndUser, Integer> {
	//List<Customer> findByFirstName(String firstName);
	
	EndUser findByEmailId(String emailId);
	
	@Query(value ="select * from customer c where c.full_name = :fullName",nativeQuery=true)
	List<EndUser> getAllByFullName(@Param("fullName")String fullName);
	
	@Query(value ="select * from customer c where c.mobile_number = :mobileNumber",nativeQuery=true)
	EndUser getByMobileNumber(@Param("mobileNumber") String mobileNumber);	
	
}
