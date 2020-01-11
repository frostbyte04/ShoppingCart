package com.gs.service.impl;

import com.gs.domain.*;
import com.gs.repo.CartItemRepository;
import com.gs.repo.GuitarToCartItemRepository;
import com.gs.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private GuitarToCartItemRepository guitarToCartItemRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Override
    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getGuitar().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    @Override
    public CartItem addGuitarToCartItem( Guitar guitar, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart((user.getShoppingCart()));
        for (CartItem cartItem : cartItemList){
            if (guitar.getId() == cartItem.getGuitar().getId()){
                cartItem.setQty(cartItem.getQty()+qty);
                cartItem.setSubtotal(new BigDecimal(guitar.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setGuitar(guitar);

        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(guitar.getOurPrice()).multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        GuitarToCartItem guitarToCartItem = new GuitarToCartItem();
        guitarToCartItem.setGuitar(guitar);
        guitarToCartItem.setCartItem(cartItem);
        guitarToCartItemRepository.save(guitarToCartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(Long cartItemId) throws Exception {
        Optional<CartItem> optional = cartItemRepository.findById( cartItemId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Product with given id does not exist");
        }
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        guitarToCartItemRepository.deleteByCartItem(cartItem);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }
}
