package com.gs.service.impl;

import com.gs.domain.UserPayment;
import com.gs.domain.UserShipping;
import com.gs.repo.UserPaymentRepository;
import com.gs.service.UserPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    @Autowired
    private UserPaymentRepository userPaymentRepository;

    @Override
    public UserPayment findById(Long id) throws Exception {
        Optional<UserPayment> optional =userPaymentRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Product with given id does not exist");
        }
    }

    @Override
    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }
}
