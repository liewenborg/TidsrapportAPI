package com.example;


import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBManager {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /* Method to  READ all the employees */
    public void listUsers() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List users = session.createQuery("FROM UsersEntity").list();
            for (Iterator iterator =
                 users.iterator(); iterator.hasNext(); ) {
                UsersEntity user = (UsersEntity) iterator.next();
                System.out.print(" Fullname: " + user.getFullname());
                System.out.print(" Email: " + user.getEmail());
                System.out.println("  Password: " + user.getPass());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}




