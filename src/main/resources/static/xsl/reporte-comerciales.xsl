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
						<td colspan="7" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="7" class="titulo-reporte">REPORTE DIARIO <span class="nombre-reporte">COMERCIALES</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="3" class="value"><xsl:value-of select="reporteComercial/numero"/></td>
						<td colspan="1" class="label">Revisado por:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteComercial/revisadoPor"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="3" class="value"><xsl:value-of select="reporteComercial/elaboradoPor"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteComercial/fecha"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Hora Entrada:</td>
						<td colspan="3" class="value"><xsl:value-of select="reporteComercial/horaEntrada"/></td>
						<td colspan="1" class="label">Hora Salida:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteComercial/horaSalida"/></td>
					</tr>
					<tr>
						<td colspan="1" class="subtitulo-cabecera">No.</td>
						<td colspan="1" class="subtitulo-cabecera">Fecha</td>
						<td colspan="1" class="subtitulo-cabecera">Nombre</td>
						<td colspan="1" class="subtitulo-cabecera">Poblacion</td>
						<td colspan="1" class="subtitulo-cabecera">Reparto</td>
						<td colspan="1" class="subtitulo-cabecera">Cobro</td>
						<td colspan="1" class="subtitulo-cabecera">Pedido</td>
					</tr>
					<xsl:for-each select="reporteComercial/actividadesComercial/reporte">
						<tr>
							<td rowspan="3" class="data"><xsl:value-of select="id"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="fecha"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="nombre"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="poblacion"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="reparto"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="cobro"/></td>
							<td rowspan="1" class="data"><xsl:value-of select="pedido"/></td>
						</tr>
						<tr>
							<td colspan="1" class="subtitulo-cabecera-left">Incidencias</td>
							<td colspan="5" class="data-left"><xsl:value-of select="incidencias"/></td>
						</tr>
						<tr>
							<td colspan="1" class="subtitulo-cabecera-left">Observaciones</td>
							<td colspan="5" class="data-left"><xsl:value-of select="observaciones"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
