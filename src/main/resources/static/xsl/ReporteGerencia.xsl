<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../static/css/reporte-gerencia.css" />
			</head>
			<body>
				<table class="reporte">
					<tr>
						<td colspan="13" class="titulo-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="13" class="titulo-reporte">REPORTE DIARIO DE <span class="nombre-reporte">COMERCIALES</span></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Reporte:</td>
						<td colspan="12" class="value border-right"><xsl:value-of select="reporteGerencia/titulo"/></td>
					</tr>
					<tr>
						<td colspan="1" class="label border-left">Elaborado:</td>
						<td colspan="9" class="value"><xsl:value-of select="reporteGerencia/titulo"/></td>
						<td colspan="1" class="label">Fecha:</td>
						<td colspan="2" class="value border-right"><xsl:value-of select="reporteGerencia/titulo"/></td>
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
					<tr class="odd">
						<td class="data">1</td>
						<td class="data">2</td>
						<td class="data">3</td>
						<td class="data">4</td>
						<td class="data">5</td>
						<td class="data">6</td>
						<td class="data">7</td>
						<td class="data">8</td>
						<td class="data">9</td>
						<td class="data">10</td>
						<td class="data">11</td>
						<td class="data">12</td>
						<td class="data">13</td>
					</tr>
					<tr class="even">
						<td class="data">1</td>
						<td class="data">2</td>
						<td class="data">3</td>
						<td class="data">4</td>
						<td class="data">5</td>
						<td class="data">6</td>
						<td class="data">7</td>
						<td class="data">8</td>
						<td class="data">9</td>
						<td class="data">10</td>
						<td class="data">11</td>
						<td class="data">12</td>
						<td class="data">13</td>
					</tr>
					<tr class="odd">
						<td class="data">1</td>
						<td class="data">2</td>
						<td class="data">3</td>
						<td class="data">4</td>
						<td class="data">5</td>
						<td class="data">6</td>
						<td class="data">7</td>
						<td class="data">8</td>
						<td class="data">9</td>
						<td class="data">10</td>
						<td class="data">11</td>
						<td class="data">12</td>
						<td class="data">13</td>
					</tr>
					<tr class="even">
						<td class="data">1</td>
						<td class="data">2</td>
						<td class="data">3</td>
						<td class="data">4</td>
						<td class="data">5</td>
						<td class="data">6</td>
						<td class="data">7</td>
						<td class="data">8</td>
						<td class="data">9</td>
						<td class="data">10</td>
						<td class="data">11</td>
						<td class="data">12</td>
						<td class="data">13</td>
					</tr>
					<tr>
						<td class="data-footer">Total:</td>
						<td class="data-footer">3</td>
						<td class="data-footer">6</td>
						<td class="data-footer">9</td>
						<td class="data-footer">15</td>
						<td class="data-footer">18</td>
						<td class="data-footer">21</td>
						<td class="data-footer">24</td>
						<td class="data-footer">27</td>
						<td class="data-footer">30</td>
						<td class="data-footer">33</td>
						<td class="data-footer">36</td>
						<td class="data-footer">39</td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
