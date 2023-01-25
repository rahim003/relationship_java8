package peaksoft.java8.configurations;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

/**
 * @author krasa kurbanov
 * @created 25/01/2023 - 11:56
 **/
public class HibernateConfiguration {
    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.hibernate.Driver");
        properties.put(Environment.URL, "jdbc:/postgres://localhost:5432/session");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "123123");
        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        final SessionFactory sessionFactory = getSessionFactory();
        return sessionFactory.unwrap(EntityManagerFactory.class);
    }
}
