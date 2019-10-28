package by.epam.task05.oop_and_la.dao.factory;


import by.epam.task05.oop_and_la.dao.TransactionDAO;
import by.epam.task05.oop_and_la.dao.UserDAO;
import by.epam.task05.oop_and_la.dao.impl.FileTransactionDAO;
import by.epam.task05.oop_and_la.dao.impl.FileUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO fileUserImpl = new FileUserDAO();
    private final TransactionDAO fileTransactionImpl = new FileTransactionDAO();


    public static DAOFactory getInstance() {
        return instance;
    }
    public UserDAO getUserDAO() {
        return fileUserImpl;
    }
    public TransactionDAO getTransactionDAO() {
        return fileTransactionImpl;
    }
}
