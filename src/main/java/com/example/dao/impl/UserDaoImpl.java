package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllData() throws Exception {
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("test");
		user.setSalary(5000);
		user.setAge(14);
		list.add(user);
		return list;
	}

	@Override
	public boolean saveData(User klass) throws Exception {
		return false;
	}

	@Override
	public boolean updateData(User klass) throws Exception {
		return false;
	}

	@Override
	public boolean deleteData(User klass) throws Exception {
		return false;
	}


	@Override
	public boolean isUserExist(User user) throws Exception {
		return false;
	}

	@Override
	public User getSingleData(User klass) throws Exception {
		return null;
	}

}
