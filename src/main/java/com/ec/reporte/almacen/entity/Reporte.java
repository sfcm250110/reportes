package com.ec.reporte.almacen.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "REPORTE")
public class Reporte implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "REPORTE_ID_SEQ", sequenceName = "REPORTE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORTE_ID_SEQ")
	private Long id;

	@Column
	private Long idActividad;

	@Column
	private String numero;

	@Column
	@NotBlank
	private String tipo;

	@Column
	private String elaboradoPor;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date fechaDesde;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date fechaHasta;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "dd-mm-yyyy HH:mm")
	private Date fechaCreacion;

	@Transient
	private List<Actividad> actividades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Long getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

}