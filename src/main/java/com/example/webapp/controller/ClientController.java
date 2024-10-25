package com.example.webapp.controller;


import com.example.webapp.Dao.ClientDao;
import com.example.webapp.Model.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api") // route /api par default pour chaque route
public class ClientController {

    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    /**
     *  Retourne tous les clients
     * @return
     */
    @GetMapping(value = "/clients")
    public String clients() {
        return clientDao.findAll().toString();
    }

    /**
     * Retourne un client par son ID
     * @param id
     * @return
     */
    @GetMapping(value = "/clients/{id}")
    public Client client(@PathVariable int id) {
        return clientDao.findById(id);
    }

    /**
     *  Ajouter un client
     * @param client
     */
    @PostMapping(value = "/clients")
    public void addClient(@RequestBody Client client) {
        clientDao.save(client);
    }

    /**
     *  Modifier un client par son ID
     * @param client
     * @param id
     */
    @PutMapping(value = "/clients/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable int id) {
        client.setId(id);
        clientDao.save(client);
    }

    /**
     *  Suprime un client par son ID
     * @param id
     */
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        clientDao.delete(clientDao.findById(id));
    }

}
