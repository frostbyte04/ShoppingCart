package com.adminportal.service.impl;

import com.adminportal.domain.Guitar;
import com.adminportal.repo.GuitarRepository;
import com.adminportal.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuitarServiceImpl implements GuitarService {

    @Autowired
    private GuitarRepository guitarRepository;

    public Guitar save(Guitar guitar) {
        return guitarRepository.save(guitar);
    }

    @Override
    public List<Guitar> findAll() {
        return (List<Guitar>) guitarRepository.findAll();
    }

    @Override
    public Optional<Guitar> findById(Long id) {
        return guitarRepository.findById(id);
    }

    @Override
    public void removeOne(Long id) {
        guitarRepository.deleteById(id);

    }

}
