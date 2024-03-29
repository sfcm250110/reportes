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
						<td colspan="5" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="5" class="titulo-reporte">REPORTE DIARIO <span class="nombre-reporte">COMERCIAL</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteComercial/numero"/></td>
						<td colspan="1" class="label">Revisado por:</td>
						<td colspan="1" class="value border-right"><xsl:value-of select="reporteComercial/revisadoPor"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteComercial/elaboradoPor"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="1" class="value border-right"><xsl:value-of select="reporteComercial/fecha"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Hora Entrada:</td>
						<td colspan="2" class="value"><xsl:value-of select="reporteComercial/horaEntrada"/></td>
						<td colspan="1" class="label">Hora Salida:</td>
						<td colspan="1" class="value border-right"><xsl:value-of select="reporteComercial/horaSalida"/></td>
					</tr>
					<tr>
						<td colspan="1" class="subtitulo-cabecera">Nombre</td>
						<td colspan="1" class="subtitulo-cabecera">Poblacion</td>
						<td colspan="1" class="subtitulo-cabecera">Reparto</td>
						<td colspan="1" class="subtitulo-cabecera">Cobro</td>
						<td colspan="1" class="subtitulo-cabecera">Pedido</td>
					</tr>
					<tr>
						<td class="data"><xsl:value-of select="reporteComercial/nombre"/></td>
						<td class="data"><xsl:value-of select="reporteComercial/poblacion"/></td>
						<td class="data"><xsl:value-of select="reporteComercial/reparto"/></td>
						<td class="data"><xsl:value-of select="reporteComercial/cobro"/></td>
						<td class="data"><xsl:value-of select="reporteComercial/pedido"/></td>
					</tr>
					<tr>
						<td colspan="5" class="subtitulo-cabecera-left">Incidencias</td>
					</tr>
					<tr>
						<td colspan="5" class="data-left"><xsl:value-of select="reporteComercial/incidencias"/></td>
					</tr>
					<tr>
						<td colspan="5" class="subtitulo-cabecera-left">Observaciones</td>
					</tr>
					<tr>
						<td colspan="5" class="data-left"><xsl:value-of select="reporteComercial/observaciones"/></td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
