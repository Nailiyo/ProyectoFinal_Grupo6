package com.edu.unju.edm.PV2023;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.edu.unju.edm.PV2023.service.imp.ImpMySQLLoginService;

@Configuration
@EnableWebSecurity
public class ConfiguracionWeb extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Autenticacion autenticacion;
	
	String[] resources = new String [] {"/include/**", "/css/**", "/icons/**","/img/**", "/js/**", "/layer/**","/webjars/**"};
	
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/", "/index", "/cargarAlumno", "/cuestionarioAlumno").permitAll()
				.antMatchers("/mostrarDocente", "/mostrarCuestionario", "/cargarDocente", "/cargarCuestionario", "/cargarPregunta").hasAuthority("ADMIN")
				.anyRequest().authenticated()	
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("idDocente")
				.passwordParameter("contraseñaDocente")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login?logout");
	}
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}
	
	@Autowired
	ImpMySQLLoginService userDetailsService;
	
	@Autowired
	public void configuracionGlobal(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("INICIA USUARIO CABRON");
		
		auth.userDetailsService(userDetailsService);
	}
}
