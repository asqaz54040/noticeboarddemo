package tw.com.sam.config;

import java.util.Properties;


import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"tw.com.sam"})
@EnableTransactionManagement
public class RootAppConfig {
	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/connectSqlServerJdbc/Noteproject");
		jndiBean.afterPropertiesSet();
		DataSource ds=(DataSource)jndiBean.getObject();
		return ds;
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("tw.com.sam");
		factoryBean.setHibernateProperties(addProperties());
		return factoryBean;
	}
	
	private Properties addProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect",  org.hibernate.dialect.MySQL8Dialect.class);
		prop.put("hibernate.show_sql",  Boolean.TRUE);
		prop.put("hibernate.format_sql",  Boolean.TRUE);
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(factory);
		return txMgr;
	}
}
