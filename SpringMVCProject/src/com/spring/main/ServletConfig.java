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
@ComponentScan(basePackages = {"com.spring.main.controller",
		"com.spring.main.service","com.spring.main.db","com.spring.main.model"})
public class ServletConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/jsps/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DataSource getDataSource(){ //DataSource DriverManagerDataSource
		DriverManagerDataSource ds = new DriverManagerDataSource();
		//url
		ds.setUrl("jdbc:mysql://localhost:3306/mycompanydb_55555");
		//username
		ds.setUsername("root");
		//password
		ds.setPassword(""); //Password123
		//driver
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return ds;
	}
	 
}
