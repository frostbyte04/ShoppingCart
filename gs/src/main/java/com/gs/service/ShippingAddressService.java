package com.gs.service;

import com.gs.domain.ShippingAddress;
import com.gs.domain.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
