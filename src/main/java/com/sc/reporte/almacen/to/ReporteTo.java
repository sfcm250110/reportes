package com.sc.reporte.almacen.to;

import java.io.Serializable;
import java.util.List;

import com.sc.reporte.almacen.entity.Actividad;

public class ReporteTo implements Serializable {

	private static final long serialVersionUID = -6878236750238405077L;

	private String numero;
	private String elaboradoPor;
	private String fecha;
	private List<Actividad> actividades;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getElaboradoPor() {
		return elaboradoPor;
	}

	public void setElaboradoPor(String elaboradoPor) {
		this.elaboradoPor = elaboradoPor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

}
