package com.example.webapp.Dao;

import com.example.webapp.Model.User;

import java.util.List;

public interface ClientDao {
    List<User> findAll();

    User findById(int id);

    User save(User user);

    User delete(User user);


}
