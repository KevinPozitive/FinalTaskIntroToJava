package by.epam.task05.oop_and_la.service;

import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.service.exception.ServiceException;

public interface UserService {
    boolean signIn(AuthorizationInfo authInfo) throws ServiceException;
    void signOut(AuthorizationInfo authInfo) throws ServiceException;
}
