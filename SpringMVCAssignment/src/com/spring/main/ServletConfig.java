package com.spring.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring.main.controller","com.spring.main.service","com.spring.main.model",
"com.spring.main.DB"})
public class ServletConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolve() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/jsps/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DataSource getDataSource(){ 
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/assignment_2000080620");
		ds.setUsername("root");
		ds.setPassword("Password123");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");	
		return ds;
	}
}
