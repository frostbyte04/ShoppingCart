package com.gs.service.impl;

import com.gs.domain.Guitar;
import com.gs.repo.GuitarRepository;
import com.gs.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuitarServiceImpl implements GuitarService {
    @Autowired
    private GuitarRepository guitarRepository;

    public List<Guitar> findAll() {
        List<Guitar> guitarList = (List<Guitar>)guitarRepository.findAll();

        List<Guitar> activeGuitarList = new ArrayList<>();

        for (Guitar guitar: guitarList){
            if (guitar.isActive()){
                activeGuitarList.add(guitar);
            }
        }
        return activeGuitarList;
    }


    public Guitar findById(Long id) throws Exception{
        Optional<Guitar> optional = guitarRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Product with given id does not exist");
        }
    }

    @Override
    public List<Guitar> findByCategory(String category) {
        List<Guitar> guitarList = guitarRepository.findByCategory(category);

        List<Guitar> activeGuitarList = new ArrayList<>();

        for (Guitar guitar: guitarList){
            if (guitar.isActive()){
                activeGuitarList.add(guitar);
            }
        }
        return activeGuitarList;
    }

    @Override
    public List<Guitar> blurrySearch(String title) {
        List<Guitar> guitarList = guitarRepository.findByNameContaining(title);

        List<Guitar> activeGuitarList = new ArrayList<>();

        for (Guitar guitar: guitarList){
            if (guitar.isActive()){
                activeGuitarList.add(guitar);
            }
        }
        return activeGuitarList;
    }
}
