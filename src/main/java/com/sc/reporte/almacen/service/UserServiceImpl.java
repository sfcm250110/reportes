package com.sc.reporte.almacen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ec.reporte.almacen.entity.User;
import com.sc.reporte.almacen.dto.ChangePasswordForm;
import com.sc.reporte.almacen.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepository userRepository;

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			user = userRepository.save(user);
		}

		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("Usuario no existe"));

		return user;
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);

		return userRepository.save(toUser);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws Exception {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new Exception("UsernotFound in deleteUser -" + this.getClass().getName()));

		userRepository.delete(user);
	}

	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User storedUser = userRepository.findById(form.getId()).orElseThrow(() -> new Exception("UsernotFound in ChangePassword."));

		if (!isLoggedUserADMIN() && form.getCurrentPassword().equals(storedUser.getPassword())) {
			throw new Exception("Current Password incorrecto.");
		}

		if (storedUser.getPassword().equals(form.getNewPassword())) {
			throw new Exception("Nuevo debe ser diferente al password actual.");
		}

		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("Nuevo Password y Confirm Password no coinciden.");
		}

		
		String encoderPassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		storedUser.setPassword(encoderPassword);

		return userRepository.save(storedUser);
	}

	/**
	 * Map everythin but the password.
	 * 
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from, User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = userRepository.findByUsername(user.getUsername());

		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
			// throw new CustomeFieldValidationException("Username no disponible",
			// "username");
		}

		return true;
	}

	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
			// throw new CustomeFieldValidationException("Confirm Password es obligatorio",
			// "confirmPassword");
		}

		if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y Confirm Password no son iguales");
			// throw new CustomeFieldValidationException("Password y Confirm Password no son
			// iguales", "password");
		}

		return true;
	}
	
	private boolean isLoggedUserADMIN() {
		return loggedUserHasRole("ROLE_ADMIN");
	}

	private boolean loggedUserHasRole(String role) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails loggedUser = null;
		Object roles = null;
		
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			roles = loggedUser.getAuthorities().stream().filter(x -> role.equals(x.getAuthority())).findFirst()
					.orElse(null); // loggedUser = null;
		}
		
		return roles != null ? true : false;
	}

}