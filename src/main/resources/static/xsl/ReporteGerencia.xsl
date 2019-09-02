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
					<caption class="border-top-radius">Chocolates Marcos Tonda</caption>
					<thead>
						<tr>
							<th colspan="13">REPORTE DIARIO DE <span class="titulo-reporte">COMERCIALES</span></th>
						</tr>
						<tr class="align-left no-border-bottom">
							<th colspan="1" class="align-left no-border-right height-25 background-datos">Reporte:</th>
							<th colspan="12" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></th>
						</tr>
						<tr>
							<th colspan="1" class="align-left no-border-right height-25 background-datos">Elaborado:</th>
							<th colspan="9" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></th>
							<th colspan="1" class="align-left no-border-right no-border-left background-datos">Fecha:</th>
							<th colspan="2" class="align-left font-weight-normal background-datos"><xsl:value-of select="reporteGerencia/titulo"/></th>
						</tr>
						<tr>
							<th colspan="6">Horarios</th>
							<th rowspan="3">Población</th>
							<th rowspan="3">Cliente</th>
							<th rowspan="3">Visita</th>
							<th rowspan="3">Cobro</th>
							<th rowspan="3">Pedido</th>
							<th rowspan="3">Otros</th>
							<th rowspan="3">Incidencias</th>
						</tr>
						<tr>
							<th colspan="2" class="centro negrita">Por la manana</th>
							<th colspan="2" class="centro negrita">Por la tarde</th>
							<th colspan="2" class="centro negrita">Total Horas</th>
						</tr>
						<tr>
							<th class="centro negrita">Entrada</th>
							<th class="centro negrita">Salida</th>
							<th class="centro negrita">Entrada</th>
							<th class="centro negrita">Salida</th>
							<th class="centro negrita">Ordinarias</th>
							<th class="centro negrita">Extraordinarias</th>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
					<tfoot>
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
					</tfoot>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
