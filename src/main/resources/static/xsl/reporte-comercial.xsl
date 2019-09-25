<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../static/css/reportes.css" />
			</head>
			<body>
				<table class="reporte">
					<tr>
						<td colspan="13" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="13" class="titulo-reporte">REPORTE DIARIO DE <span class="nombre-reporte">COMERCIAL</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="12" class="value border-right"><xsl:value-of select="reporteComercial/numero"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="9" class="value"><xsl:value-of select="reporteComercial/elaboradoPor"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteComercial/fecha"/></td>
					</tr>
					<tr>
						<td colspan="6" class="subtitulo-cabecera">Horarios</td>
						<td rowspan="3" class="subtitulo-cabecera">Población</td>
						<td rowspan="3" class="subtitulo-cabecera">Cliente</td>
						<td rowspan="3" class="subtitulo-cabecera">Visita</td>
						<td rowspan="3" class="subtitulo-cabecera">Cobro</td>
						<td rowspan="3" class="subtitulo-cabecera">Pedido</td>
						<td rowspan="3" class="subtitulo-cabecera">Otros</td>
						<td rowspan="3" class="subtitulo-cabecera">Incidencias</td>
					</tr>
					<tr>
						<td colspan="2" class="subtitulo-cabecera">Por la mañana</td>
						<td colspan="2" class="subtitulo-cabecera">Por la tarde</td>
						<td colspan="2" class="subtitulo-cabecera">Total Horas</td>
					</tr>
					<tr>
						<td class="subtitulo-cabecera">Entrada</td>
						<td class="subtitulo-cabecera">Salida</td>
						<td class="subtitulo-cabecera">Entrada</td>
						<td class="subtitulo-cabecera">Salida</td>
						<td class="subtitulo-cabecera">Ordinarias</td>
						<td class="subtitulo-cabecera">Extra</td>
					</tr>
					<xsl:for-each select="reporteComercial/actividades/actividad">
						<tr>
							<td class="data"><xsl:value-of select="horaEntradaManana"/></td>
							<td class="data"><xsl:value-of select="horaSalidaManana" /></td>
							<td class="data"><xsl:value-of select="horaEntradaTarde"/></td>
							<td class="data"><xsl:value-of select="horaSalidaTarde" /></td>
							<td class="data"><xsl:value-of select="horaEntradaManana"/></td>
							<td class="data"><xsl:value-of select="horaSalidaManana" /></td>
							<td class="data"><xsl:value-of select="poblacion"/></td>
							<td class="data"><xsl:value-of select="cliente" /></td>
							<td class="data"><xsl:value-of select="visita"/></td>
							<td class="data"><xsl:value-of select="cobro" /></td>
							<td class="data"><xsl:value-of select="pedido"/></td>
							<td class="data"><xsl:value-of select="otros" /></td>
							<td class="data"><xsl:value-of select="incidencias"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
