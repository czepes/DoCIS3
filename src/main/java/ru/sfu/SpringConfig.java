package ru.sfu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * Configuration class for Spring Framework
 * @author Agapchenko V.V.
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan("ru.sfu")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    private Environment env;

    /**
     * Set environment field
     * @param env Spring Environment
     */
    @Autowired
    private void environment(Environment env) {
        this.env = env;
    }

    /**
     * Initialize Data Source
     * @return DataSource Object
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                Objects.requireNonNull(
                        env.getProperty("dataSource.driverClassName")
                )
        );
        dataSource.setUrl(
                env.getProperty("dataSource.url")
        );
        dataSource.setUsername(
                env.getProperty("dataSource.username")
        );
        dataSource.setPassword(
                env.getProperty("dataSource.password")
        );

        return dataSource;
    }

    /**
     * Initialize Manager Factory
     * @return Manager Factory Object
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.sfu.entity");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    /**
     * Initialize Transaction Manager
     * @return Transaction Manager Object
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        return manager;
    }
}
