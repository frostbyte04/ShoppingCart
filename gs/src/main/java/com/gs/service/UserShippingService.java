package com.gs.service;

import com.gs.domain.UserShipping;

import java.util.Optional;

public interface UserShippingService {

    UserShipping findById(Long id) throws Exception;

    void removeById(Long userShippingId);
}
