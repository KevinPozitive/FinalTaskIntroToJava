package by.epam.task05.oop_and_la.dao;


import by.epam.task05.oop_and_la.bean.Transaction;
import by.epam.task05.oop_and_la.dao.exception.DAOException;

import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transaction transaction) throws DAOException;
    List<Transaction> readTransactions() throws DAOException;
    void deleteTransaction(int transactionId) throws DAOException;
    void deleteTransaction(Transaction transaction) throws DAOException;
    Transaction findTransactionById(int transactionId) throws DAOException;
    int lastId() throws DAOException;
}
