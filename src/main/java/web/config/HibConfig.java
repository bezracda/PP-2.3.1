//package web.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.DriverManager;
//import java.util.Objects;
//import java.util.Properties;
//@Configuration
//@EnableJpaRepositories("web")
//@PropertySource("classpath:db.properties")
//@EnableTransactionManagement
//@ComponentScan(value = "web")
//public class HibConfig {
//    private final Environment env;
//
//    public HibConfig(Environment env) {
//        this.env = env;
//    }
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
//        ds.setUrl(env.getProperty("db.url"));
//        ds.setUsername(env.getProperty("db.username"));
//        ds.setPassword(env.getProperty("db.password"));
//
//
//        return ds;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(getDataSource());
//        em.setPackagesToScan("web");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        em.setJpaProperties(getHibernateProperties());
//        return em;
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
//        JpaTransactionManager jtm = new JpaTransactionManager();
//        jtm.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return jtm;
//    }
//
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        try {
//            InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
//            properties.load(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return properties;
//    }
//
//}