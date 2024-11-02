package lk.ijse.dao.impl;


import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dao.UserDao;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {



    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int user) {
        return false;
    }

    @Override
    public User find(String id) {
        return null;
    }


    public List<String> getAllRoles() {
        List<String> roles = new ArrayList<>();

        try (Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession()) {
            // Use HQL to get distinct roles
            String hql = "SELECT DISTINCT role FROM User";
            Query<String> query = session.createQuery(hql, String.class);
            roles = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }

    @Override
    public List<User> getUserDetails(User user) {
        List<User> list = new ArrayList<>(); // Initialize an empty list to return

        // Use try-with-resources to ensure session is closed properly
        try (Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession()) {
            Transaction tx = session.beginTransaction();

            // Create the query and set parameters
            Query<User> query = session.createQuery("from User");
             list = query.list();



            tx.commit(); // Commit the transaction
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }

        // Print the list before returning



        return list; // Return the list (it will be empty if no valid user was found)
    }




}
