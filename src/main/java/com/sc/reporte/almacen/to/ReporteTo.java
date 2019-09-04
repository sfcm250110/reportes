package com.sc.reporte.almacen.to;

import java.io.Serializable;
import java.util.List;

import com.ec.reporte.almacen.entity.Actividad;

public class ReporteTo implements Serializable {

	private static final long serialVersionUID = -6878236750238405077L;

	private String numero;
	private String elaboradoPor;
	private String fecha;
	private String totalEntradaManana;
	private String totalSalidaManana;
	private String totalEntradaTarde;
	private String totalSalidaTarde;
	private String totalOrdinarias;
	private String totalExtras;
	private String totalPoblacion;
	private String totalCliente;
	private String totalVisita;
	private String totalCobro;
	private String totalPedido;
	private String totalOtros;
	private String totalIncidencias;
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

	public String getTotalEntradaManana() {
		return totalEntradaManana;
	}

	public void setTotalEntradaManana(String totalEntradaManana) {
		this.totalEntradaManana = totalEntradaManana;
	}

	public String getTotalSalidaManana() {
		return totalSalidaManana;
	}

	public void setTotalSalidaManana(String totalSalidaManana) {
		this.totalSalidaManana = totalSalidaManana;
	}

	public String getTotalEntradaTarde() {
		return totalEntradaTarde;
	}

	public void setTotalEntradaTarde(String totalEntradaTarde) {
		this.totalEntradaTarde = totalEntradaTarde;
	}

	public String getTotalOrdinarias() {
		return totalOrdinarias;
	}

	public void setTotalOrdinarias(String totalOrdinarias) {
		this.totalOrdinarias = totalOrdinarias;
	}

	public String getTotalSalidaTarde() {
		return totalSalidaTarde;
	}

	public void setTotalSalidaTarde(String totalSalidaTarde) {
		this.totalSalidaTarde = totalSalidaTarde;
	}

	public String getTotalExtras() {
		return totalExtras;
	}

	public void setTotalExtras(String totalExtras) {
		this.totalExtras = totalExtras;
	}

	public String getTotalPoblacion() {
		return totalPoblacion;
	}

	public void setTotalPoblacion(String totalPoblacion) {
		this.totalPoblacion = totalPoblacion;
	}

	public String getTotalCliente() {
		return totalCliente;
	}

	public void setTotalCliente(String totalCliente) {
		this.totalCliente = totalCliente;
	}

	public String getTotalVisita() {
		return totalVisita;
	}

	public void setTotalVisita(String totalVisita) {
		this.totalVisita = totalVisita;
	}

	public String getTotalCobro() {
		return totalCobro;
	}

	public void setTotalCobro(String totalCobro) {
		this.totalCobro = totalCobro;
	}

	public String getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(String totalPedido) {
		this.totalPedido = totalPedido;
	}

	public String getTotalOtros() {
		return totalOtros;
	}

	public void setTotalOtros(String totalOtros) {
		this.totalOtros = totalOtros;
	}

	public String getTotalIncidencias() {
		return totalIncidencias;
	}

	public void setTotalIncidencias(String totalIncidencias) {
		this.totalIncidencias = totalIncidencias;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}

}
