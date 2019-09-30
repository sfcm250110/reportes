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
						<td colspan="9" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="9" class="titulo-reporte">REPORTE DIARIO DE <span class="nombre-reporte">ALMACENES</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="8" class="value border-right"><xsl:value-of select="reporteAlmacen/numero"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="5" class="value"><xsl:value-of select="reporteAlmacen/elaboradoPor"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteAlmacen/fecha"/></td>
					</tr>
					<tr>
						<td rowspan="2" class="subtitulo-cabecera">Hora Entrada</td>
						<td rowspan="2" class="subtitulo-cabecera">Hora Salida</td>
						<td colspan="7" class="subtitulo-cabecera">Pedidos Preparados</td>
					</tr>
					<tr>
						<td colspan="1" class="subtitulo-cabecera">Visita</td>
						<td colspan="1" class="subtitulo-cabecera">Cobro</td>
						<td colspan="1" class="subtitulo-cabecera">Pedido</td>
						<td colspan="1" class="subtitulo-cabecera">Proveedores</td>
						<td colspan="1" class="subtitulo-cabecera">Repartos</td>
						<td colspan="1" class="subtitulo-cabecera">Observaciones</td>
						<td colspan="1" class="subtitulo-cabecera">Incidencias</td>
					</tr>
					<xsl:for-each select="reporteAlmacen/actividades/actividad">
						<tr>
							<td class="data"><xsl:value-of select="horaEntrada"/></td>
							<td class="data"><xsl:value-of select="horaSalida" /></td>
							<td class="data"><xsl:value-of select="visita"/></td>
							<td class="data"><xsl:value-of select="cobro" /></td>
							<td class="data"><xsl:value-of select="pedido"/></td>
							<td class="data"><xsl:value-of select="proveedores" /></td>
							<td class="data"><xsl:value-of select="repartos" /></td>
							<td class="data"><xsl:value-of select="observaciones"/></td>
							<td class="data"><xsl:value-of select="incidencias"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
