package com.mymock.dao;

import com.mymock.domain.User;

/**
 * Created by rkavya on 3/24/2015.
 */
public interface ILoginDAO {

    boolean login(User user);
    void addUser(User user);
}
