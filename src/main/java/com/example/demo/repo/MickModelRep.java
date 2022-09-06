package com.example.demo.repo;

import com.example.demo.models.MickModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MickModelRep extends CrudRepository<MickModel, Long> {
}
