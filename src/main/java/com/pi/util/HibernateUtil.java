package com.pi.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = fabricaSessionFactory();

    public static SessionFactory fabricaSessionFactory() {
        
        try {
            Configuration configuracao = new Configuration().configure();
            StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder()
                    .applySettings(configuracao.getProperties());
            StandardServiceRegistry servico = registradorServico.build();
            SessionFactory fabrica = configuracao.buildSessionFactory();
            return fabrica;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
