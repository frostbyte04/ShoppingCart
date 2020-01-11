package com.gs.repo;

import com.gs.domain.Guitar;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuitarRepository extends CrudRepository<Guitar, Long> {


    List<Guitar> findByCategory(String category);

    List<Guitar> findByNameContaining(String title);
}
