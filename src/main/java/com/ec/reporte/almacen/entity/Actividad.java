package com.ec.reporte.almacen.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private Date fechaCreacion;

	@Column
	@NotBlank
	private String tipo;

	@Column
	@NotBlank
	private String poblacion;

	@Column
	@NotBlank
	private String cliente;

	@Column
	@NotBlank
	private String visita;

	@Column
	@NotBlank
	private String cobro;

	@Column
	@NotBlank
	private String pedido;

	@Column
	@NotBlank
	private String otros;

	@Column
	@NotBlank
	private String incidencias;

	@Column
	@NotBlank
	private Date horaEntradaManana;

	@Column
	@NotBlank
	private Date horaSalidaManana;

	@Column
	@NotBlank
	private Date horaEntradaTarde;

	@Column
	@NotBlank
	private Date horaSalidaTarde;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getVisita() {
		return visita;
	}

	public void setVisita(String visita) {
		this.visita = visita;
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

}