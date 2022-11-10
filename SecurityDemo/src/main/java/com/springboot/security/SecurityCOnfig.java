package com.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityCOnfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
		 .passwordEncoder(getPassowrdEncoder())
		 .withUser("harry").password(getPassowrdEncoder().encode("potter")).roles("ADMIN")
		 .and()
		 .withUser("ronald").password(getPassowrdEncoder().encode("weasley")).roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		 .antMatchers(HttpMethod.GET, "/hello/public").permitAll()
		 .antMatchers(HttpMethod.GET, "/hello/private").authenticated()
		 .and().httpBasic()
		 .and().csrf().disable();
	}
	
	public PasswordEncoder getPassowrdEncoder() {
		return new BCryptPasswordEncoder();
	}
}
