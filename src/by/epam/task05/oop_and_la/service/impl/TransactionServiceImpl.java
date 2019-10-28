package by.epam.task05.oop_and_la.service.impl;


import by.epam.task05.oop_and_la.bean.Transaction;
import by.epam.task05.oop_and_la.dao.TransactionDAO;
import by.epam.task05.oop_and_la.dao.exception.DAOException;
import by.epam.task05.oop_and_la.dao.factory.DAOFactory;
import by.epam.task05.oop_and_la.service.TransactionService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void createTransaction(Transaction transaction) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TransactionDAO transactionDAO = daoFactory.getTransactionDAO();
            transactionDAO.addTransaction(transaction);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Transaction readTransaction(int transactionId) throws ServiceException {
        if (transactionId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TransactionDAO transactionDAO = daoFactory.getTransactionDAO();
            Transaction transaction = transactionDAO.findTransactionById(transactionId);

            return transaction;

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateTransaction(int transactionId, Transaction newTransaction) throws ServiceException {
        if (transactionId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TransactionDAO transactionDAO = daoFactory.getTransactionDAO();

            Transaction oldTransaction = transactionDAO.findTransactionById(transactionId);
            transactionDAO.deleteTransaction(oldTransaction);
            transactionDAO.addTransaction(newTransaction);

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTransaction(int transactionId) throws ServiceException {
        if (transactionId < 0) {
            throw new ServiceException("Incorrect id");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            TransactionDAO transactionDAO = daoFactory.getTransactionDAO();
            transactionDAO.deleteTransaction(transactionId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
