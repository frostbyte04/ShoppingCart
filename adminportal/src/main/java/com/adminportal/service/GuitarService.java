package com.adminportal.service;

import com.adminportal.domain.Guitar;

import java.util.List;
import java.util.Optional;

public interface GuitarService {
    Guitar save(Guitar guitar);

    List<Guitar> findAll();

    Optional<Guitar> findById(Long id);

    void removeOne(Long id);
}
