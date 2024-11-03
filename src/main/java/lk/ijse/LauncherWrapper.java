package lk.ijse;

import lk.ijse.config.SessionFactoryConfuguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LauncherWrapper  {
    public static void main(String[] args) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();

        Launcher.main(args);
    }


}

