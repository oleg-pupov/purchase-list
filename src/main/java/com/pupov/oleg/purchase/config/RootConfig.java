package com.pupov.oleg.purchase.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pupov.oleg.purchase.controllers.Controllers;
import com.pupov.oleg.purchase.dao.Dao;
import com.pupov.oleg.purchase.service.Logic;

@Configuration
@ComponentScan(basePackageClasses = {Controllers.class, DatabaseConfig.class, Dao.class, Logic.class})
public class RootConfig extends WebMvcConfigurerAdapter {
	
}
