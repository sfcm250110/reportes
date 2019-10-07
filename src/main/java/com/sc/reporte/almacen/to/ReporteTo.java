package com.sc.reporte.almacen.to;

import java.io.Serializable;
import java.util.List;

import com.sc.reporte.almacen.entity.Actividad;
import com.sc.reporte.almacen.entity.ActividadComercial;
import com.sc.reporte.almacen.entity.ReporteAlmacen;

public class ReporteTo implements Serializable {

	private static final long serialVersionUID = -6878236750238405077L;

	private String numero;
	private String elaboradoPor;
	private String revisadoPor;
	private String fecha;
	private ReporteAlmacen reporteAlmacen;
	private ActividadComercial actividadComercial;
	private List<Actividad> actividades;
	private List<ActividadComercial> actividadesComercial;

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

	public String getRevisadoPor() {
		return revisadoPor;
	}

	public void setRevisadoPor(String revisadoPor) {
		this.revisadoPor = revisadoPor;
	}

	public ReporteAlmacen getReporteAlmacen() {
		return reporteAlmacen;
	}

	public void setReporteAlmacen(ReporteAlmacen reporteAlmacen) {
		this.reporteAlmacen = reporteAlmacen;
	}

	public ActividadComercial getActividadComercial() {
		return actividadComercial;
	}

	public void setActividadComercial(ActividadComercial actividadComercial) {
		this.actividadComercial = actividadComercial;
	}

	public List<ActividadComercial> getActividadesComercial() {
		return actividadesComercial;
	}

	public void setActividadesComercial(List<ActividadComercial> actividadesComercial) {
		this.actividadesComercial = actividadesComercial;
	}

}
