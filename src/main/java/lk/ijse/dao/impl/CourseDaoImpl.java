package lk.ijse.dao.impl;

import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dao.CourseDao;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Student;
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
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        session.update(courses);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public boolean delete(String t) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Courses.class, t));
        tx.commit();
        session.close();
        return true;
    }


    @Override
    public Courses find(String id) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        Courses courses = (Courses) session.get(Courses.class, id);
        tx.commit();
        session.close();
        return courses;
    }


}
