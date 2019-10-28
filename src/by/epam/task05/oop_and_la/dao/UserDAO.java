package by.epam.task05.oop_and_la.dao;


import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(AuthorizationInfo authInfo) throws DAOException;
}
