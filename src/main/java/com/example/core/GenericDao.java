package com.example.core;

import java.util.List;

public interface GenericDao<T> {
	 public List<T> getAllData() throws Exception;
	 public boolean saveData(T klass) throws Exception;
	 public boolean updateData(T klass) throws Exception;
	 public boolean deleteData(T klass) throws Exception;
	 public T getSingleData(T klass) throws Exception;
}
