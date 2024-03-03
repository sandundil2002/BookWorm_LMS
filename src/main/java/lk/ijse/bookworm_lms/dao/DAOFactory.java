package lk.ijse.bookworm_lms.dao;

import lk.ijse.bookworm_lms.dao.custom.impl.AdminDAOImpl;
import lk.ijse.bookworm_lms.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        USER,ADMIN
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case USER:
                return new UserDAOImpl();
            case ADMIN:
                return new AdminDAOImpl();
            default:
                return null;
        }
    }
}
