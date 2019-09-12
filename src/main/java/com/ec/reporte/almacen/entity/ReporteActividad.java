package com.ec.reporte.almacen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "REPORTE_ACTIVIDAD")
public class ReporteActividad implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "REPORTE_ACTIVIDAD_ID_SEQ", sequenceName = "REPORTE_ACTIVIDAD_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORTE_ACTIVIDAD_ID_SEQ")
	private Long id;

	@Column(name = "ID_REPORTE")
	private Long idReporte;

	@Column(name = "ID_ACTIVIDAD")
	private Long idActividad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(Long idReporte) {
		this.idReporte = idReporte;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

}