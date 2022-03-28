package com.cs.service;

import java.util.List;

import com.cs.bean.EndUser;
import com.cs.dto.Register;

public interface IEndUserService {

	EndUser addCustomer(Register endUser);
	List<EndUser> getAllUser();
}
