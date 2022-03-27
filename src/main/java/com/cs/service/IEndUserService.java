package com.cs.service;

import java.util.List;

import com.cs.bean.EndUser;

public interface IEndUserService {

	EndUser addCustomer(EndUser endUser);
	List<EndUser> getAllUser();
}
