package com.sc.reporte.almacen.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "USUARIO")
public class User implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "USUARIO_ID_SEQ", sequenceName = "USUARIO_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ID_SEQ")
	private Long id;

	@Column
	@NotBlank(message = "No puede estar vacio")
	@Size(min = 5, max = 8, message = "No se cumple las reglas de tamanio")
	private String firstName;

	@Column
	@NotBlank
	private String lastName;

	@Column
	@NotBlank
	private String email;

	@Column
	@NotBlank
	private String username;

	@Column
	@NotBlank
	private String password;

	@Transient
	private String confirmPassword;

	@Size(min = 1)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USUARIO_ROLES", joinColumns = @JoinColumn(name = "USUARIO_ID"), inverseJoinColumns = @JoinColumn(name = "ROL_ID"))
	private Set<Role> roles;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}