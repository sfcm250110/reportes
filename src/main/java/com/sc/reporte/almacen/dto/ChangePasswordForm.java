package com.sc.reporte.almacen.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePasswordForm {

	@NotNull
	private Long id;

	@NotBlank(message = "La clave actual no debe estar vacia")
	private String currentPassword;

	@NotBlank(message = "La nueva clave no debe estar vacia")
	private String newPassword;

	@NotBlank(message = "La clave de confirmacion no debe estar vacia")
	private String confirmPassword;

	public ChangePasswordForm() {
	}

	public ChangePasswordForm(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}