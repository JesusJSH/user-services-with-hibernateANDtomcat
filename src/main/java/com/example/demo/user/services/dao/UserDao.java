package com.example.demo.user.services.dao;


import com.example.demo.user.services.config.HibernateConfiguration;
import com.example.demo.user.services.entity.User;
import org.hibernate.*;

import java.io.Serializable;

public class UserDao {
    private final SessionFactory sessionFactory;


    public UserDao() {
        this.sessionFactory = HibernateConfiguration.getSessionFactory();
    }
    public User getByID(Integer id){
        Session session = null;
        Transaction transaction = null;
        User user = null;

        try {
            session = sessionFactory.openSession();
            transaction =  session.beginTransaction();
            user = (User)session.get(User.class, id);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return user;
    }

    public User createUser(User user){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction =  session.beginTransaction();
            session.save(user);
            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return user;
    }
    public void updateUser(User user){
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction =  session.beginTransaction();
            Query query = session.createQuery("UPDATE users SET name=:name, surname=:surname, age=:age where id=:id");
            query.setParameter("name",user.getName());
            query.setParameter("surname",user.getSurname());
            query.setParameter("age",user.getAge());
            query.setParameter("id",user.getId());
            query.executeUpdate();

            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }
        finally {
            if (session != null){
                session.close();
            }
        }
    }

}
