package com.sc.reporte.almacen.exception;

public class ReporteNotFound extends Exception {

	private static final long serialVersionUID = -1620298632876557825L;

	public ReporteNotFound() {
		super("Reporte no encontrado");
	}

	public ReporteNotFound(String msg) {
		super(msg);
	}
}
