package com.example.webapp.Dao;

import com.example.webapp.Model.Client;

import java.util.List;

public interface ClientDao {
    List<Client> findAll();

    Client findById(int id);

    Client save(Client client);

    Client delete(Client client);
}
