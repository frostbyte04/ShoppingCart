package com.gs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qty;
    private BigDecimal subtotal;

    @OneToOne
    private Guitar guitar;

        @OneToMany(mappedBy = "cartItem")
        @JsonIgnore
        private List<GuitarToCartItem> guitarToCartItemList;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "oerder_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    public List<GuitarToCartItem> getGuitarToCartItemList() {
        return guitarToCartItemList;
    }

    public void setGuitarToCartItemList(List<GuitarToCartItem> guitarToCartItemList) {
        this.guitarToCartItemList = guitarToCartItemList;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
