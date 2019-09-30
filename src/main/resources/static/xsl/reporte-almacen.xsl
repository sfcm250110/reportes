<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="estiloReportesCss" />
			</head>
			<body>
				<table class="reporte">
					<tr>
						<td colspan="6" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="6" class="titulo-reporte">REPORTE DIARIO DEL <span class="nombre-reporte">ALMACÉN</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteAlmacen/numero"/></td>
						<td colspan="1" class="label">Revisado por:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteAlmacen/revisadoPor"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteAlmacen/elaboradoPor"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteAlmacen/fecha"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Hora Entrada:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteAlmacen/horaEntrada"/></td>
						<td colspan="1" class="label">Hora Salida:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteAlmacen/horaSalida"/></td>
					</tr>
					<tr>
						<td colspan="6" class="subtitulo-cabecera">Pedidos Preparados</td>
					</tr>
					<tr>
						<td colspan="1" class="subtitulo-cabecera">Frank</td>
						<td colspan="1" class="subtitulo-cabecera">Vicente</td>
						<td colspan="1" class="subtitulo-cabecera">Integra</td>
						<td colspan="1" class="subtitulo-cabecera">George</td>
						<td colspan="1" class="subtitulo-cabecera">Blue</td>
						<td colspan="1" class="subtitulo-cabecera">Otros</td>
					</tr>
					<tr>
						<td class="data"><xsl:value-of select="reporteAlmacen/frank"/></td>
						<td class="data"><xsl:value-of select="reporteAlmacen/vicente"/></td>
						<td class="data"><xsl:value-of select="reporteAlmacen/integra"/></td>
						<td class="data"><xsl:value-of select="reporteAlmacen/george"/></td>
						<td class="data"><xsl:value-of select="reporteAlmacen/blue"/></td>
						<td class="data"><xsl:value-of select="reporteAlmacen/otros"/></td>
					</tr>
					<tr>
						<td colspan="3" class="subtitulo-cabecera">Proveedores Descargados</td>
						<td colspan="3" class="subtitulo-cabecera">Repartos George</td>
					</tr>
					<tr>
						<td colspan="3" class="data"><xsl:value-of select="reporteAlmacen/proveedoresDescargados"/></td>
						<td colspan="3" class="data"><xsl:value-of select="reporteAlmacen/repartosGeorge"/></td>
					</tr>
					<tr>
						<td colspan="6" class="subtitulo-cabecera">Observaciones</td>
					</tr>
					<tr>
						<td colspan="6" class="data"><xsl:value-of select="reporteAlmacen/observaciones"/></td>
					</tr>
					<tr>
						<td colspan="6" class="subtitulo-cabecera">Incidencias</td>
					</tr>
					<tr>
						<td colspan="6" class="data"><xsl:value-of select="reporteAlmacen/incidencias"/></td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
