package by.epam.task05.oop_and_la.service.impl;


import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.dao.UserDAO;
import by.epam.task05.oop_and_la.dao.exception.DAOException;
import by.epam.task05.oop_and_la.dao.factory.DAOFactory;
import by.epam.task05.oop_and_la.service.UserService;
import by.epam.task05.oop_and_la.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws ServiceException {
        if (authInfo.getLogin() == null || authInfo.getLogin().isEmpty()) {
            throw new ServiceException("Incorrect login");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            if (userDAO.signIn(authInfo)) {
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(AuthorizationInfo authInfo) throws ServiceException {

    }
}
