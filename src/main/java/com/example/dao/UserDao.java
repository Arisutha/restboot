package com.example.dao;

import com.example.core.GenericDao;
import com.example.model.User;

public interface UserDao extends GenericDao<User>{
	public boolean isUserExist(User user) throws Exception;
}
