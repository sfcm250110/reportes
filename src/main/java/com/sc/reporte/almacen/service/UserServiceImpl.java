package com.sc.reporte.almacen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.reporte.almacen.entity.User;
import com.sc.reporte.almacen.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			//String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			//user.setPassword(encodedPassword);
			user = userRepository.save(user);
		}
		
		return user;
	}

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = userRepository.findByUsername(user.getUsername());
		
		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
			//throw new CustomeFieldValidationException("Username no disponible", "username");
		}
		
		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
			//throw new CustomeFieldValidationException("Confirm Password es obligatorio", "confirmPassword");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y Confirm Password no son iguales");
			//throw new CustomeFieldValidationException("Password y Confirm Password no son iguales", "password");
		}
		
		return true;
	}

}