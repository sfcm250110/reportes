package com.sc.reporte.almacen.service;

import com.ec.reporte.almacen.entity.User;
import com.sc.reporte.almacen.dto.ChangePasswordForm;
import com.sc.reporte.almacen.exception.UsernameOrIdNotFound;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Long id) throws UsernameOrIdNotFound;

	public User updateUser(User user) throws UsernameOrIdNotFound;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;

	public User changePassword(ChangePasswordForm form) throws Exception;

}