package com.epam.test_task.service.impl;

import com.epam.test_task.dao.UserDAO;
import com.epam.test_task.dao.exception.DAOException;
import com.epam.test_task.model.User;
import com.epam.test_task.service.UserService;
import com.epam.test_task.service.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private UserDAO userDAO;
    //private BCryptPasswordEncoder encoder;

    public void create(User user) throws ServiceException {
        LOGGER.log(Level.INFO, "start service create user");
        try {
            userDAO.create(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public User findByLogin(String login) throws ServiceException {
        User user;
        try {
            user = userDAO.findByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
