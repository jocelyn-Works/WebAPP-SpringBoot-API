package com.example.webapp.Repository;

import com.example.webapp.Model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer>{

}
