package com.example.demo.repo;

import com.example.demo.models.MickModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MickModelRep extends CrudRepository<MickModel, Long> {
    List<MickModel> findByTitle(String string);

    List<MickModel> findByTitleContains(String string);
}
