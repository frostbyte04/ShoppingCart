package com.gs.service;

import com.gs.domain.BillingAddress;
import com.gs.domain.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
