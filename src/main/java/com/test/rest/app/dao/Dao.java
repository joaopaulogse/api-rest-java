package com.test.rest.app.dao;

import java.net.UnknownHostException;
import java.util.List;

import com.test.rest.app.models.Users;

public interface Dao {

	
	void add(Users users) throws UnknownHostException;
	
	List<Users> findAll() throws UnknownHostException;
	
	void delete(Users users) throws UnknownHostException;
}
