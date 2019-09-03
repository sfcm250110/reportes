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
						<td colspan="13" class="border-top-radius reporte-cabecera">Chocolates Marcos Tonda</td>
					</tr>
					<tr>
						<td colspan="13" class="reporte-subtitulo">REPORTE DIARIO DE <span class="titulo-reporte">COMERCIALES</span></td>
					</tr>
					<tr class="align-left no-border-bottom">
						<td colspan="1" class="align-left no-border-right height-25 background-datos">Reporte:</td>
						<td colspan="12" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></td>
					</tr>
					<tr>
						<td colspan="1" class="align-left no-border-right height-25 background-datos">Elaborado:</td>
						<td colspan="9" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></td>
						<td colspan="1" class="align-left no-border-right no-border-left background-datos">Fecha:</td>
						<td colspan="2" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></td>
					</tr>
					<tr>
						<td colspan="6">Horarios</td>
						<td rowspan="3">Población</td>
						<td rowspan="3">Cliente</td>
						<td rowspan="3">Visita</td>
						<td rowspan="3">Cobro</td>
						<td rowspan="3">Pedido</td>
						<td rowspan="3">Otros</td>
						<td rowspan="3">Incidencias</td>
					</tr>
					<tr>
						<td colspan="2" class="centro negrita">Por la mañana</td>
						<td colspan="2" class="centro negrita">Por la tarde</td>
						<td colspan="2" class="centro negrita">Total Horas</td>
					</tr>
					<tr>
						<td class="centro negrita">Entrada</td>
						<td class="centro negrita">Salida</td>
						<td class="centro negrita">Entrada</td>
						<td class="centro negrita">Salida</td>
						<td class="centro negrita">Ordinarias</td>
						<td class="centro negrita">Extraordinarias</td>
					</tr>
					<tr class="odd">
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
						<td>6</td>
						<td>7</td>
						<td>8</td>
						<td>9</td>
						<td>10</td>
						<td>11</td>
						<td>12</td>
						<td>13</td>
					</tr>
					<tr class="even">
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
						<td>6</td>
						<td>7</td>
						<td>8</td>
						<td>9</td>
						<td>10</td>
						<td>11</td>
						<td>12</td>
						<td>13</td>
					</tr>
					<tr>
						<td class="border-bottom-left-radius padding-5">Total:</td>
						<td>3</td>
						<td>6</td>
						<td>9</td>
						<td>15</td>
						<td>18</td>
						<td>21</td>
						<td>24</td>
						<td>27</td>
						<td>30</td>
						<td>33</td>
						<td>36</td>
						<td class="border-bottom-right-radius">39</td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
