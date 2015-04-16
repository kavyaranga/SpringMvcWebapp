package com.mymock.dao;

import com.mymock.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

/**
 * Created by rkavya on 3/24/2015.
 */
@Repository
public class LoginDAO  implements ILoginDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user){

        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean login(User user) {

        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username and u.password=:password");

        query.setString("username",user.getUsername());
        query.setString("password",user.getPassword());

        User us = (User)query.uniqueResult();

        System.out.println(query.uniqueResult());
        System.out.println("User name from db is: " + us.getUsername());
        System.out.println("User name from form is: "+ user.getUsername());

        if((us.getUsername().equals(user.getUsername()))&&(us.getPassword().equals(user.getPassword())))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
