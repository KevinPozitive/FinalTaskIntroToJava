package by.epam.task05.oop_and_la.dao.impl;


import by.epam.task05.oop_and_la.bean.AuthorizationInfo;
import by.epam.task05.oop_and_la.dao.UserDAO;
import by.epam.task05.oop_and_la.dao.exception.DAOException;
import by.epam.task05.oop_and_la.dao.util.FinInfoReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUserDAO implements UserDAO {

    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws DAOException {
        try (FinInfoReader fileNoteReader = new FinInfoReader("./src/by/epam/task05/oop_and_la/resource/AuthInfo.txt")) {
            String s = fileNoteReader.readNote();
            String[] info = s.split(" ");

            AuthorizationInfo infoFromFile = new AuthorizationInfo(info[0], info[1]);

            if (authInfo.equals(infoFromFile)) {
                return true;
            }
            return false;

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
