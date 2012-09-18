/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package remote.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import remote.model.impl.Allocation;
import remote.model.impl.Lab;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
        	 Configuration configuration = new Configuration().setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/laballocremote")
        			 .setProperty("hibernate.connection.username", "root")
        			 .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
        			 .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        			 .setProperty("hibernate.show_sql", "true")
        			 .setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory")
        			 .setProperty("hibernate.current_session_context_class", "thread")
        			 .setProperty("hbm2ddl.auto", "update")
        			 .addAnnotatedClass(Allocation.class)
        			 .addAnnotatedClass(Lab.class);
           
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
