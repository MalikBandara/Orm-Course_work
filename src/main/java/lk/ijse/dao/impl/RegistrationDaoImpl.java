package lk.ijse.dao.impl;

import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dao.RegistrationDao;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {
//    @Override
//    public boolean save(Registration registration) {
//        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
//        Transaction tx = session.beginTransaction();
//        session.save(registration);
//        tx.commit();
//        session.close();
//        return true;
//    }
//@Override
//public boolean save(Registration registration) {
//    Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
//    Transaction tx = session.beginTransaction();
//    try {
//        // Step 1: Save the Registration entity
//        session.save(registration);
//
//        // Step 2: Retrieve the corresponding Payment entity
//        Payment payment = registration.getPayment();
//
//        if (payment != null) {
//            // Step 3: Update the balance in Payment with the advanced amount from Registration
//            payment.setBalance(payment.getBalance() + registration.getAdvanced()); // Add advanced amount to balance
//            session.update(payment); // Save the updated Payment entity
//        }
//
//        // Commit the transaction
//        tx.commit();
//        return true;
//    } catch (Exception e) {
//        // Rollback the transaction in case of an error
//        tx.rollback();
//        e.printStackTrace();
//        return false;
//    } finally {
//        // Close the session to release resources
//        session.close();
//    }
//}
public boolean save(Registration registration) {
    Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
    Transaction tx = session.beginTransaction();

    try {

        session.save(registration);


        Payment payment = registration.getPayment();


        if (payment != null) {

            payment.setBalance(payment.getBalance() + registration.getAdvanced());


            double newPaidAmount = payment.getAmount() - registration.getAdvanced();
            payment.setPaidAmount(newPaidAmount);


            session.update(payment);
        }


        tx.commit();
        return true;

    } catch (Exception e) {

        if (tx != null) {
            tx.rollback();
        }

        return false;

    } finally {

        session.close();
    }
}



    @Override
    public boolean update(Registration registration) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        try {

            session.update(registration);
            tx.commit();
            session.close();
            return true;
        }catch (Exception e){
            tx.rollback();
            return false;
        }

    }

    @Override
    public boolean delete(int t) {
        return false;
    }

    @Override
    public boolean delete(String t) {
        try {
            Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
            Transaction tx = session.beginTransaction();
            session.delete(session.get(Registration.class, t));
            tx.commit();
            session.close();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public Registration find(String id) {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        Registration registration = (Registration) session.get(Registration.class, id);
        tx.commit();
        session.close();
        return registration;
    }

    @Override
    public List<Courses> getIds() {

        List<Courses> coursesList = new ArrayList<>();
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Courses";
        Query<Courses> query = session.createQuery(hql, Courses.class);
        coursesList = query.list();
        tx.commit();
        session.close();
        return coursesList;


    }

    @Override
    public List<Student> getStudentIds() {
        List<Student> StudentList = new ArrayList<>();
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Student";
        Query<Student> query = session.createQuery(hql, Student.class);
        StudentList = query.list();
        tx.commit();
        session.close();
        return StudentList;
    }

    @Override
    public List<Registration> loadTable() {
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        List <Registration> list  = session.createQuery("from Registration").list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public List<Payment> getpayId() {
        List<Payment> paymentlist = new ArrayList<>();
        Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Payment";
        Query<Payment> query = session.createQuery(hql, Payment.class);
        paymentlist = query.list();
        tx.commit();
        session.close();
        return paymentlist;
    }


}
