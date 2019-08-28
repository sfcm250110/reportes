package com.sc.reporte.almacen.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeLeaf {

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}