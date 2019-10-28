package by.epam.task05.oop_and_la.service;


import by.epam.task05.oop_and_la.bean.Transaction;
import by.epam.task05.oop_and_la.service.exception.ServiceException;

public interface TransactionService {
    void createTransaction(Transaction transaction) throws ServiceException;
    Transaction readTransaction(int transactionId) throws ServiceException;
    void updateTransaction(int transactionId, Transaction transaction) throws ServiceException;
    void deleteTransaction(int transactionId) throws ServiceException;
}
