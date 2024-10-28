package com.example.webapp.controller;


import com.example.webapp.Dao.ClientDao;
import com.example.webapp.Model.Client;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api") // route /api par default pour chaque route
public class ClientController {

    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    /**
     * Retourne tous les clients
     *
     * @return
     */
    @GetMapping(value = "/clients")
    public List<Client> clients() {
        return clientDao.findAll();
    }

    /**
     * Retourne un client par son ID
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/clients/{id}")
    public Client client(@PathVariable int id) {
        return clientDao.findById(id);
    }

    /**
     * Ajouter un client
     *
     * @param client
     * @return
     */
    @PostMapping(value = "/clients")
    public Client addClient(@RequestBody Client client) {

        RestTemplate restTemplate = new RestTemplate();
        String permitNumber = client.getPermitNumber();

        String api = "http://127.0.0.1:8081/licenses/" + permitNumber;
        Boolean valid = restTemplate.getForObject(api, Boolean.class);

        if (Boolean.TRUE.equals(valid)) {
            client.setValid(true);
            clientDao.save(client);

        }

        return client;
    }


    /**
     * Modifier un client par son ID
     *
     * @param client
     * @param id
     * @return
     */
    @PutMapping(value = "/clients/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable int id) {

        Client updatedClient = clientDao.findById(id);
        client.setId(updatedClient.getId());

        updatedClient.setFirstName(client.getFirstName());
        updatedClient.setLastName(client.getLastName());
        updatedClient.setBirthDate(client.getBirthDate());
        updatedClient.setPermitNumber(client.getPermitNumber());

        return updatedClient;
    }


    /**
     * Suprime un client par son ID
     *
     * @param id
     */
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        clientDao.delete(clientDao.findById(id));

    }

}
