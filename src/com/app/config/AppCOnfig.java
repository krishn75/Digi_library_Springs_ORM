package com.app.config;

import java.util.Properties;

import org.apache.catalina.User;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Books;
import com.app.model.Category;
import com.app.model.Issued_books;
import com.app.model.Reserved_books;
import com.app.model.Users;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages="com.app")
@PropertySource("classpath:m.properties")
public class AppCOnfig {
	@Autowired
	private Environment e;	
	
	@Bean
	public Properties hbp()
	{
		Properties p=new Properties();
		p.setProperty("hibernate.dialect", e.getProperty("dialect"));
		p.setProperty("hibernate.show_sql", e.getProperty("show"));
		p.setProperty("hibernate.format_sql", e.getProperty("format"));
		p.setProperty("hibernate.hbm2ddl.auto", e.getProperty("hbm2ddl"));
		
		return p;
	}
	
	@Bean
	public BasicDataSource bds() {
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName(e.getProperty("driver"));
		bds.setUrl(e.getProperty("url"));
		bds.setUsername(e.getProperty("un"));
		bds.setPassword(e.getProperty("pwd"));
		
		return bds;
	}
	
	@Bean
	public LocalSessionFactoryBean lsf()
	{
		LocalSessionFactoryBean lsf=new LocalSessionFactoryBean();
		lsf.setAnnotatedClasses(Users.class,Category.class,Books.class,Issued_books.class,Reserved_books.class);
		lsf.setDataSource(bds());
		lsf.setHibernateProperties(hbp());
		return lsf;
	}
	
	@Bean
	public HibernateTransactionManager htm() {
	
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(lsf().getObject());
		return htm;
	}
	
	@Bean
	public InternalResourceViewResolver ivr()
	{
		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}

}
