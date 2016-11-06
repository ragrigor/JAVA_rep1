package ru.web.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.web.mantis.model.Users;

import java.util.List;

/**
 * Created by Радочка on 28.10.2016.
 */
public class DbHelper  {
    private final SessionFactory sessionFactory;

    public DbHelper(ApplicationManager app){
// A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }


    public List<Users> users() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Users> result = session.createQuery( "from Users" ).list();
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

   /* public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> result = session.createQuery("from ContactData where deprecated ='0000-00-00'").list();
        session.getTransaction().commit();
        session.close();
        return new Contacts(result);
    } */


