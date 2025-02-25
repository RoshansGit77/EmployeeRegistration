package com.oakland.configuration;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class AppContext {

	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean lsb = new LocalSessionFactoryBean();
		lsb.setDataSource(dataSource());
		lsb.setPackagesToScan(new String[] { "com.oakland.model" });
		lsb.setHibernateProperties(hibernateProperties());

		return lsb;
	}
	
	private Properties hibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));

		return prop;
	}

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName(environment.getRequiredProperty("database.driver"));
		dmds.setUrl(environment.getRequiredProperty("database.url"));
		dmds.setUsername(environment.getRequiredProperty("database.username"));
		dmds.setPassword(environment.getRequiredProperty("database.password"));

		return dmds;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {

		HibernateTransactionManager hmt = new HibernateTransactionManager();
		hmt.setSessionFactory(sessionFactoryBean().getObject());
		return hmt;
	}

}
