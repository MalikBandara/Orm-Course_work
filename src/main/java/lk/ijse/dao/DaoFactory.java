package lk.ijse.dao;

import lk.ijse.dao.impl.StudentDaoImpl;
import lk.ijse.dao.impl.UserDaoImpl;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    public SuperDao getDao(DaoType daoType) {
        switch (daoType) {
            case User :
                return new UserDaoImpl();

            case Student:
                return new StudentDaoImpl();

        }
        return null;
    }
}
