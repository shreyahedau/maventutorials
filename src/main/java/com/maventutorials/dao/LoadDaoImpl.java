package com.maventutorials.dao;

import com.maventutorials.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoadDaoImpl implements LoadDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUser() {
        try {
            Query query = this.sessionFactory.getCurrentSession().createQuery(" from User");

            return query.list();
        } catch (Exception e) {

            return new ArrayList();
        }
    }
}
