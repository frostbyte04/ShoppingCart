package com.gs.service;

import com.gs.domain.Payment;
import com.gs.domain.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
