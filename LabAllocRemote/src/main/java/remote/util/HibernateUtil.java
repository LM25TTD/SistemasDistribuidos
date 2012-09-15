/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package remote.util;


import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
        	 Configuration configuration = new Configuration().addResource("hibernate.cfg.xml");
        	 configuration.configure();
        	 configuration.buildMappings();
        	 serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        	 sessionFactory =configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            
        	System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
