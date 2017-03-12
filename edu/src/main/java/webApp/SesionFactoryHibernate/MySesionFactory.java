package webApp.SesionFactoryHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MySesionFactory {

	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
	    if (sessionFactory == null) {
	        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("../resources/hibernateMaping.xml").build();
	        Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	        sessionFactory = metaData.getSessionFactoryBuilder().build();
	    }
	    return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

	public static void shutdown() {
	    sessionFactory.getCurrentSession().close();
	}
}
