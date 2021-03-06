package com.upgrad.movie.common;
import com.upgrad.movie.model.Movie;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.springframework.beans.factory.annotation.Autowired;


public class SessionManager {

    public Session openSession() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Movie.class);
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.setFlushMode(FlushMode.MANUAL);
        ManagedSessionContext.bind(session);
        session.beginTransaction();
        return session;
    }

    public void commitSession(final Session session) {
        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}