package com.example.webapp.controller;


import com.example.webapp.Model.User;
import com.example.webapp.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * Retourne tous les utilisateurs
     *
     * @return
     */
    @GetMapping(value = "/user")
    public List<User> clients() {
        return (List<User>) userRepository.findAll();
    }


    /**
     * Retourne un utilisateur par son ID
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public Optional<User> client(@PathVariable int id) {
        return userRepository.findById(id);
    }


    /**
     * Ajouter un utilisateur
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public ResponseEntity<String> addClient(@RequestBody User user) {

        permitAPI(user);

        return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
    }


    /**
     * Modifier un utilisateur par son ID
     *
     * @param user
     * @param id
     * @return
     */
    @PutMapping(value = "/user/{id}")
    public ResponseEntity<String> updateClient(@RequestBody User user, @PathVariable int id) {

        userRepository.findById(id);

        user.setId(user.getId());

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setBirthDate(user.getBirthDate());
        user.setPermitNumber(user.getPermitNumber());

        permitAPI(user);

        return  new ResponseEntity<String>("User Updated", HttpStatus.CREATED);
    }



    /**
     * Suprime un utilisateur par son ID
     *
     * @param id
     */
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<String>("User Deleted", HttpStatus.CREATED);

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
