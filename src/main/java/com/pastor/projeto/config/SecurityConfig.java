package com.pastor.projeto.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    .withUser("tiago").password("tiago").roles("CADASTRAR_CARRO")
	       .and()
	        .withUser("maria").password("maria").roles("LISTAR_CARRO", "CADASTRAR_CARRO");
	    
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		  .antMatchers("/layout/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		   .authorizeRequests()
		   .antMatchers("/carros/novo").hasRole("CADASTRAR_CARRO")
		   .antMatchers("/carros/**").hasRole("LISTAR_CARRO")
		       .anyRequest().authenticated()
		      .and()
		      .formLogin()
		          .loginPage("/login")
		          .permitAll()
		         .and()
		       .logout()
		          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
	}

}
