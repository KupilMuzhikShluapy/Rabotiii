package com.example.demo.repo;

import com.example.demo.models.HeadphoneModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadphoneModelRep extends CrudRepository<HeadphoneModel, Long> {
    List<HeadphoneModel> findByTitle(String string);

    List<HeadphoneModel> findByTitleContains(String string);
}
