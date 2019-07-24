package com.sc.reporte.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.reporte.almacen.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public Iterable getAllUsers() {
		return userRepository.findAll();
	}

}