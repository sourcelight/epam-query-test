package org.query.calc;

import java.util.Properties;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@ComponentScans(
		{@ComponentScan(basePackages = "org.query")})
@EnableJpaRepositories
public class QueryConfiguration {
	
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean sessionFactory() {
//	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//	    
//	    sessionFactory.setHibernateProperties(hibernateProperties());
	    
	    LocalContainerEntityManagerFactoryBean factory;
	    factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setPersistenceProvider(new HibernatePersistenceProvider());
	    factory.setPackagesToScan("org.query.model.entity","org.query.repository","org.query.calc");
	    factory.setJpaProperties(hibernateProperties());
	    	   
	   
	    return factory;
	} 
	
	
	Properties hibernateProperties() {
	      return new Properties() {
	         /**
	         * 
	         */
	        private static final long serialVersionUID = 1L;

	        {	
	        	setProperty("hibernate.connection.url", "jdbc:h2:mem:testdb");
	            setProperty("hibernate.hbm2ddl.auto", "update");
	            setProperty("hibernate.show_sql", "true");
	            setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	            setProperty("spring.h2.console.enabled", "true");
	            setProperty("spring.h2.console.settings.web-allow-others", "true");
	         }
	      };
	
	}
	

}
