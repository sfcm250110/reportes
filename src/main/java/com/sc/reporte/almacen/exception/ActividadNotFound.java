package com.sc.reporte.almacen.exception;

public class ActividadNotFound extends Exception {

	private static final long serialVersionUID = -1620298632876557825L;

	public ActividadNotFound() {
		super("Actividad no encontrada");
	}

	public ActividadNotFound(String msg) {
		super(msg);
	}
}
