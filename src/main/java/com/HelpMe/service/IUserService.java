package com.HelpMe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.HelpMe.entity.User;
import com.HelpMe.exception.ModelNotFoundException;

public interface IUserService extends ICrud<User, Integer>{

	 public User getByDocument(String document) throws ModelNotFoundException;
	 
	 
	 public void deleteByDocument(String document) throws ModelNotFoundException ;
}
