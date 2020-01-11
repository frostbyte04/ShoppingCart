package com.gs.repo;

import com.gs.domain.CartItem;
import com.gs.domain.GuitarToCartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GuitarToCartItemRepository extends CrudRepository<GuitarToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
