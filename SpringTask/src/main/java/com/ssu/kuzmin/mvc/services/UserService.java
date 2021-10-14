package com.ssu.kuzmin.mvc.services;

import com.ssu.kuzmin.mvc.dao.IUserDao;
import com.ssu.kuzmin.mvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

    @Override
    public User update(User user) throws Exception {
        return userDao.update(user);
    }

    @Override
    public void delete(int id) throws Exception {
        User user = getById(id);
        userDao.delete(user);
    }

    @Override
    public User getById(int id) throws Exception {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
