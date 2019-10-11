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

@Entity(name = "REPORTE_ALMACEN")
public class ReporteAlmacen implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "REPORTE_ALMACEN_ID_SEQ", sequenceName = "REPORTE_ALMACEN_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORTE_ALMACEN_ID_SEQ")
	private Long id;

	@Column
	private String numero;

	@Column
	private String revisadoPor;

	@Column
	private String elaboradoPor;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
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
	private Integer frank;

	@Column
	private Integer vicente;

	@Column
	private Integer integra;

	@Column
	private Integer george;

	@Column
	private Integer blue;

	@Column
	private Integer otros;

	@Column
	private Integer proveedoresDescargados;

	@Column
	private Integer repartosGeorge;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Integer getFrank() {
		return frank;
	}

	public void setFrank(Integer frank) {
		this.frank = frank;
	}

	public Integer getVicente() {
		return vicente;
	}

	public void setVicente(Integer vicente) {
		this.vicente = vicente;
	}

	public Integer getIntegra() {
		return integra;
	}

	public void setIntegra(Integer integra) {
		this.integra = integra;
	}

	public Integer getGeorge() {
		return george;
	}

	public void setGeorge(Integer george) {
		this.george = george;
	}

	public Integer getBlue() {
		return blue;
	}

	public void setBlue(Integer blue) {
		this.blue = blue;
	}

	public Integer getOtros() {
		return otros;
	}

	public void setOtros(Integer otros) {
		this.otros = otros;
	}

	public Integer getProveedoresDescargados() {
		return proveedoresDescargados;
	}

	public void setProveedoresDescargados(Integer proveedoresDescargados) {
		this.proveedoresDescargados = proveedoresDescargados;
	}

	public Integer getRepartosGeorge() {
		return repartosGeorge;
	}

	public void setRepartosGeorge(Integer repartosGeorge) {
		this.repartosGeorge = repartosGeorge;
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