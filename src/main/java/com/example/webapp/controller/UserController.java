package com.example.webapp.controller;


import com.example.webapp.Model.User;
import com.example.webapp.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api") // route /api par default pour chaque route
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Retourne tous les clients
     *
     * @return
     */
    @GetMapping(value = "/clients")
    public List<User> clients() {
        return (List<User>) userRepository.findAll();
    }


    /**
     * Retourne un client par son ID
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/clients/{id}")
    public Optional<User> client(@PathVariable int id) {
        return userRepository.findById(id);
    }


    /**
     * Ajouter un client
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/clients")
    public Optional<User> addClient(@RequestBody User user) {

        User client = new User();
        client.setId(user.getId());
        client.setFirstName(user.getFirstName());
        client.setLastName(user.getLastName());
        client.setBirthDate(user.getBirthDate());
        client.setPermitNumber(user.getPermitNumber());

        permitAPI(client);

        return userRepository.findById(client.getId());
    }


    /**
     * Modifier un client par son ID
     *
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value = "/clients/{id}")
    public Optional<User> updateClient(@RequestBody User user, @PathVariable int id) {

        userRepository.findById(id);

        user.setId(user.getId());

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setBirthDate(user.getBirthDate());
        user.setPermitNumber(user.getPermitNumber());

        permitAPI(user);

        userRepository.save(user);

        return Optional.of(user);
    }



    /**
     * Suprime un client par son ID
     *
     * @param id
     */
    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        userRepository.deleteById(id);

    }

    public void permitAPI(User user) {
        RestTemplate restTemplate = new RestTemplate();

        String permitNumber = user.getPermitNumber();

        String api = "http://127.0.0.1:8081/licenses/" + permitNumber;
        Boolean valid = restTemplate.getForObject(api, Boolean.class);

        if (Boolean.TRUE.equals(valid)) {
            user.setIsValid(true);
            userRepository.save(user);
        }else {
            user.setIsValid(false);
        }
    }

}
