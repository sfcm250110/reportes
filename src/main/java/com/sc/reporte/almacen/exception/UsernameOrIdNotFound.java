package com.sc.reporte.almacen.exception;

public class UsernameOrIdNotFound extends Exception {

	private static final long serialVersionUID = -1620298632876557825L;

	public UsernameOrIdNotFound() {
		super("Usuario o id no encontrado");
	}
	
	public UsernameOrIdNotFound(String msg) {
		super(msg);
	}
}
