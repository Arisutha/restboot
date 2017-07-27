package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllData() throws Exception {
		return this.userDao.getAllData();
	}

	@Override
	public boolean saveData(User klass) throws Exception {
		return this.userDao.saveData(klass);
	}

	@Override
	public boolean updateData(User klass) throws Exception {
		return this.userDao.updateData(klass);
	}

	@Override
	public boolean deleteData(User klass) throws Exception {
		return this.userDao.deleteData(klass);
	}

	@Override
	public User getSingleData(User klass) throws Exception {
		return this.userDao.getSingleData(klass);
	}

	@Override
	public boolean isUserExist(User user) throws Exception{
		return this.userDao.isUserExist(user);
	}

}
