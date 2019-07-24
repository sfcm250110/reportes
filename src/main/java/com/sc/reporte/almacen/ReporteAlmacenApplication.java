package com.sc.reporte.almacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.ec.reporte.almacen.entity")
@EntityScan("com.ec.reporte.almacen.entity")
public class ReporteAlmacenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReporteAlmacenApplication.class, args);
	}

}
