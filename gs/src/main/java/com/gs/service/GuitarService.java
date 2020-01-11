package com.gs.service;

import com.gs.domain.Guitar;

import java.util.List;
import java.util.Optional;

public interface GuitarService {
    List<Guitar> findAll();

   Guitar findById(Long id) throws Exception;

    List<Guitar> findByCategory(String category);

    List<Guitar> blurrySearch(String title);
}
