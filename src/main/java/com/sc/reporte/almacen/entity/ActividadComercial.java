package com.sc.reporte.almacen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "ACTIVIDAD_COMERCIAL")
public class ActividadComercial implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "ACTIVIDAD_COMERCIAL_ID_SEQ", sequenceName = "ACTIVIDAD_COMERCIAL_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDAD_COMERCIAL_ID_SEQ")
	private Long id;

	@Column
	private String revisadoPor;

	@Column
	private String elaboradoPor;

	@Column
	// TODO: Revisar:
	// @DateTimeFormat(pattern = "dd/MM/yyyy'T'HH:mm")
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	// @Temporal(TemporalType.TIMESTAMP)
	// @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date fechaCreacion;

	@Column
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaEntrada;

	@Column
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaSalida;

	@Column
	private String nombre;

	@Column
	private String poblacion;

	@Column
	private String reparto;

	@Column
	private String cobro;

	@Column
	private String pedido;

	@Column
	private String observaciones;

	@Column
	private String incidencias;

	@Transient
	private String fechaCrear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRevisadoPor() {
		return revisadoPor;
	}

	public void setRevisadoPor(String revisadoPor) {
		this.revisadoPor = revisadoPor;
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

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getReparto() {
		return reparto;
	}

	public void setReparto(String reparto) {
		this.reparto = reparto;
	}

	public String getCobro() {
		return cobro;
	}

	public void setCobro(String cobro) {
		this.cobro = cobro;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public String getFechaCrear() {
		return fechaCrear;
	}

	public void setFechaCrear(String fechaCrear) {
		this.fechaCrear = fechaCrear;
	}

}