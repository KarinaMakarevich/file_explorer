package com.epam.test_task.service;

import com.epam.test_task.model.User;
import com.epam.test_task.service.exception.ServiceException;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    void create(User user) throws ServiceException;
    User findByLogin(String login) throws ServiceException;
}
