package lk.ijse.bookworm_lms.config;

import lk.ijse.bookworm_lms.entity.*;
import lk.ijse.bookworm_lms.entity.Transactions;
import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().loadProperties("hibernate.properties").build();
        Metadata metadata = new MetadataSources(serviceRegistry).
                addAnnotatedClass(User.class).
                addAnnotatedClass(Admin.class).
                addAnnotatedClass(Branch.class).
                addAnnotatedClass(Book.class).
                addAnnotatedClass(Transactions.class).
                getMetadataBuilder().build();
        sessionFactory = metadata.buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}