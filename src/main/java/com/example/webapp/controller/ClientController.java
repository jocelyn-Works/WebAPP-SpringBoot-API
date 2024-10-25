package com.example.webapp.controller;


import com.example.webapp.Dao.ClientDao;
import com.example.webapp.Model.Client;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping(value = "/clients")
    public String clients() {
        return clientDao.findAll().toString();
    }

    @GetMapping(value = "/clients/{id}")
    public Client client(@PathVariable int id) {
        return clientDao.findById(id);
    }

    @PostMapping(value = "/clients")
    public void addClient(@RequestBody Client client) {
        clientDao.save(client);
    }

    @PutMapping(value = "/clients/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable int id) {
        client.setId(id);
        clientDao.save(client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        clientDao.delete(clientDao.findById(id));
    }

}
