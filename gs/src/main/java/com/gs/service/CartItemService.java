package com.gs.service;

import com.gs.domain.*;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
    CartItem updateCartItem(CartItem cartItem);
    CartItem addGuitarToCartItem(Guitar guitar, User user, int qty);

    CartItem findById(Long cartItemId) throws Exception;

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);

    List<CartItem> findByOrder(Order order);
}
