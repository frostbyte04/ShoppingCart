package com.gs.service;

import com.gs.domain.UserPayment;

import java.util.Optional;

public interface UserPaymentService {
    UserPayment findById(Long id) throws Exception;
    void removeById(Long id);
}
