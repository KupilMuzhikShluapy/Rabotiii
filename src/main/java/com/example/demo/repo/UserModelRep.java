package com.example.demo.repo;

import com.example.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRep extends CrudRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}

