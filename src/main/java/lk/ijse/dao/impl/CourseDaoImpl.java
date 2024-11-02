package lk.ijse.dao.impl;

import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dao.CourseDao;
import lk.ijse.entity.Courses;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean save(Courses courses) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        session.save(courses);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Courses courses) {
        return false;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public Courses find(String id) {
        return null;
    }
}
