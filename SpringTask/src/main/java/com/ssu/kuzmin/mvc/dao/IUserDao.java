package com.ssu.kuzmin.mvc.dao;

import com.ssu.kuzmin.mvc.entities.User;
import java.util.List;

public interface IUserDao {
    User add(User user);
    User update(User user) throws Exception;
    void delete(User user) throws Exception;
    User getById(int id) throws Exception;
    List<User> getAll();
}
