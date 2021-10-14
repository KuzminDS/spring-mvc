package com.ssu.kuzmin.mvc.services;


import com.ssu.kuzmin.mvc.entities.User;

import java.util.List;

public interface IUserService {
    User add(User user);
    User update(User user) throws Exception;
    void delete(int id) throws Exception;
    User getById(int id) throws Exception;
    List<User> getAll();
}
