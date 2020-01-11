package com.gs.service.impl;

import com.gs.domain.Guitar;
import com.gs.domain.UserShipping;
import com.gs.repo.UserShippingRepository;
import com.gs.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserShippingServiceImpl implements UserShippingService {
    @Autowired
    private UserShippingRepository userShippingRepository;

    @Override
    public UserShipping findById(Long id) throws Exception {
        Optional<UserShipping> optional = userShippingRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Product with given id does not exist");
        }
    }

    @Override
    public void removeById(Long id) {
        userShippingRepository.deleteById(id);
    }
}
