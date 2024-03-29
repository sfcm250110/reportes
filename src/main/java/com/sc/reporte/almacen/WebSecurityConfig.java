package com.sc.reporte.almacen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//Indica que esta clase es de configuracion y necesita ser cargada durante el inicio del server
@Configuration

//Indica que esta clase sobreescribira la implmentacion de seguridad web
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	BCryptPasswordEncoder bCryptPasswordEncoder;

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO:
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/", "/index", "/signup").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/home").failureUrl("/login?error=true").usernameParameter("username")
				.passwordParameter("password").and().csrf().disable().logout().permitAll()
				.logoutSuccessUrl("/login?logout");

		// TODO:
		/*
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/", "/index", "/signup", "/home", "/h2-console/test.do").permitAll();
		*/
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Especificar el encargado del login y encriptacion del password
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
