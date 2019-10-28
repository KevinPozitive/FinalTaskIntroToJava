package by.epam.task05.oop_and_la.service.util;


import by.epam.task05.oop_and_la.dao.TransactionDAO;
import by.epam.task05.oop_and_la.dao.exception.DAOException;
import by.epam.task05.oop_and_la.dao.factory.DAOFactory;
import by.epam.task05.oop_and_la.service.exception.ServiceException;

public class TransactionIdGenerator {
    private static final TransactionIdGenerator instance = new TransactionIdGenerator();

    public static TransactionIdGenerator getInstance() {
        return instance;
    }

    public int nextId() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TransactionDAO transactionDAO = daoFactory.getTransactionDAO();

        try {
            int lastId = transactionDAO.lastId();
            return lastId + 1;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
