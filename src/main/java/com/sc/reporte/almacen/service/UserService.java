package com.sc.reporte.almacen.service;

import com.ec.reporte.almacen.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();
	
	public User createUser(User user) throws Exception;

}