package config;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.sql.DataSource;
import java.util.Locale;


@Configuration
@ComponentScan({"controllers", "dao", "entity", "filters", "service"})
@EnableWebMvc
public class QuizConfiguration {

    @Bean
    public SpringLiquibase springLiquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource());
        springLiquibase.setChangeLog("/resources/changelog-db.xml");
        springLiquibase.setContexts("test, production");
        return springLiquibase;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://lt80glfe2gj8p5n2.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/vt8gqxfgfiqppxq6?reconnect=true");

        dataSource.setUsername("zsxrehyldl3w659q");
        dataSource.setPassword("yf3kgxqf1gp8xn1n");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory (){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"entity"});
        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setDataSource(dataSource());
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/messages");
        messageSource.setDefaultEncoding("utf-8");
        return messageSource;
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
       localeResolver.setDefaultLocale(new Locale("en"));
        return localeResolver;
    }

}


