package com.example.service;

import com.example.core.GenericDao;
import com.example.model.User;

public interface UserService extends GenericDao<User>{
	public boolean isUserExist(User user) throws Exception;
}
