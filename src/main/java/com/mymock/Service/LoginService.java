package com.mymock.Service;

import com.mymock.dao.ILoginDAO;
import com.mymock.domain.Student;
import com.mymock.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rkavya on 3/24/2015.
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    public ILoginDAO iLoginDAO;

    @Override
    @Transactional
    public void addUser(User user){iLoginDAO.addUser(user);}

    @Override
    @Transactional
    public boolean login(User user) {
        return iLoginDAO.login(user);
    }
}
