/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import mapping.User;

public class UserDao extends HibernateUtil {

    /**
     * Inserisce un nuopvo utente nel database se non vi sono match con
     * l'username o la mail selezionati.
     *
     * @param user - L'utente da aggiungere al database
     * @return
     */
    public String add(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String result = "";
        List<User> users = null;
        /* Controllo che non vi sia già un utente con il solito username */
        String Query = "FROM User u WHERE u.username=:name ";
        try {
            users = (List<User>) session.createQuery(Query)
                    .setString("name", user.getUsername()).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        if (users != null && users.size() > 0) {
            result = "USERNAMEAP";
            return result;
        }
        /* Controllo che non vi sia già un utente con il solito username */
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query = "FROM User u WHERE u.email=:email ";
        try {
            users = (List<User>) session.createQuery(Query)
                    .setString("email", user.getEmail()).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        if (users != null && users.size() > 0) {
            result = "EMAILAP";
            return result;
        }

        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Date dateNow = new Date();
        user.setDatacreazione(dateNow);
        session.save(user);
        session.getTransaction().commit();
        result = "SUCCESS";
        return result;
    }

    /**
     * Inserisce un nuopvo utente nel database se non vi sono match con
     * l'username o la mail selezionati.
     *
     * @param user - L'utente da aggiungere al database
     * @return
     */
    public User update(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
      
        Date dateNow = new Date();
        user.setDatamodifica(dateNow);
        session.update(user);
        session.getTransaction().commit();
        return user;
    }

    public User delete(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        if (null != user) {
            session.delete(user);
        }
        session.getTransaction().commit();
        return user;
    }

    /**
     * cerca corrispondenza con utenti che hanno username e password identiche a
     * quelle inserite
     *
     * @param username - campo username dell'utente cercato
     * @param password - campo password dell'utente cercato
     * @return
     */
    public List<User> findUserForLogin(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = null;
        String Query = "FROM User u WHERE u.username=:name and u.password=:password";
        try {
            users = (List<User>) session.createQuery(Query)
                    .setString("name", username)
                    .setString("password", password).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return users;

    }

    public List<User> findUserByUnameMail(String username, String email) {
        //Vengo da azione chain di delete, setto i campi a vuoto
        if (username == null && email == null) {
            username = "";
            email = "";
        }
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = null;
        String Query = "FROM User u WHERE u.username like :name and u.email like :email";
        try {
            users = (List<User>) session.createQuery(Query)
                    .setString("name", "%" + username + "%")
                    .setString("email", "%" + email + "%").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return users;

    }

    public User findUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = null;
        String Query = "FROM User u WHERE u.id=:id";
        try {
            users = (List<User>) session.createQuery(Query)
                    .setInteger("id", id).list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return users.get(0);

    }

    public List<User> list() {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<User> users = null;
        try {
            users = (List<User>) session.createQuery("from User").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return users;
    }
}
