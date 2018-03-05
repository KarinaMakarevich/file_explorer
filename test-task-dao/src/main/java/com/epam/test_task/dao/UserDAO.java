package com.epam.test_task.dao;

import com.epam.test_task.dao.exception.DAOException;
import com.epam.test_task.model.User;

public interface UserDAO {
    User findByLogin(String login) throws DAOException;
    User findByEmail(String email) throws DAOException;
    void save(User user) throws DAOException;
    void create(User user) throws DAOException;
}
