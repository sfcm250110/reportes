package com.ec.reporte.almacen.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "ACTIVIDAD")
public class Actividad implements Serializable {

	private static final long serialVersionUID = -6833167247955613395L;

	@Id
	@SequenceGenerator(name = "ACTIVIDAD_ID_SEQ", sequenceName = "ACTIVIDAD_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDAD_ID_SEQ")
	private Long id;

	@Column
	private String elaboradoPor;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "dd-mm-yyyy HH:mm")
	private Date fechaCreacion;

	@Column
	@NotBlank
	private String poblacion;

	@Column
	@NotBlank
	private String cliente;

	@Column
	@NotNull
	private Integer visita;

	@Column
	@NotNull
	private Integer cobro;

	@Column
	@NotNull
	private Integer pedido;

	@Column
	@NotBlank
	private String otros;

	@Column
	@NotBlank
	private String incidencias;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaEntradaManana;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaSalidaManana;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaEntradaTarde;

	@Column
	@NotNull
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horaSalidaTarde;

	@Transient
	private String horaOrdinarias;

	@Transient
	private String horaExtras;

	public Actividad() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getVisita() {
		return visita;
	}

	public void setVisita(Integer visita) {
		this.visita = visita;
	}

	public Integer getCobro() {
		return cobro;
	}

	public void setCobro(Integer cobro) {
		this.cobro = cobro;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(String incidencias) {
		this.incidencias = incidencias;
	}

	public Date getHoraEntradaManana() {
		return horaEntradaManana;
	}

	public void setHoraEntradaManana(Date horaEntradaManana) {
		this.horaEntradaManana = horaEntradaManana;
	}

	public Date getHoraSalidaManana() {
		return horaSalidaManana;
	}

	public void setHoraSalidaManana(Date horaSalidaManana) {
		this.horaSalidaManana = horaSalidaManana;
	}

	public Date getHoraEntradaTarde() {
		return horaEntradaTarde;
	}

	public void setHoraEntradaTarde(Date horaEntradaTarde) {
		this.horaEntradaTarde = horaEntradaTarde;
	}

	public Date getHoraSalidaTarde() {
		return horaSalidaTarde;
	}

	public void setHoraSalidaTarde(Date horaSalidaTarde) {
		this.horaSalidaTarde = horaSalidaTarde;
	}

	public String getHoraOrdinarias() {
		return horaOrdinarias;
	}

	public void setHoraOrdinarias(String horaOrdinarias) {
		this.horaOrdinarias = horaOrdinarias;
	}

	public String getHoraExtras() {
		return horaExtras;
	}

	public void setHoraExtras(String horaExtras) {
		this.horaExtras = horaExtras;
	}

}