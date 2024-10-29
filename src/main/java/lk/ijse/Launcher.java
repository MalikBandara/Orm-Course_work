package lk.ijse;


import lk.ijse.config.SessionFactoryConfuguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Launcher {
    public static void main(String[] args) {


        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();

        System.out.println("Hello world!");
    }
}