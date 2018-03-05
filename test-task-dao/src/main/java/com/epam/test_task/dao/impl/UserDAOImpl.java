package com.epam.test_task.dao.impl;

import com.epam.test_task.dao.UserDAO;
import com.epam.test_task.dao.exception.DAOException;
import com.epam.test_task.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;

public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    /*@Autowired
    private BCryptPasswordEncoder passwordEncoder;*/

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public User findByLogin(String login) throws DAOException {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user;
        try {
            criteria.add(Restrictions.eq("login", login));
            user = (User) criteria.uniqueResult();
        } catch (Exception e) {
            throw new DAOException("Can't find user by login");
        }
        return user;
    }

    public User findByEmail(String email) throws DAOException {
        Session session = this.sessionFactory.getCurrentSession();
        User user;
        try {
            user = (User) session.load(User.class, email);
        } catch (Exception e) {
            throw new DAOException("Can't find user by email");
        }
        return user;
    }

    public void save(User user) throws DAOException {

    }

    @Transactional
    public void create(User user) throws DAOException {
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.persist(user);
        } catch (Exception e) {
            throw new DAOException("Can't create user");
        }
    }

    /*public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/
}
