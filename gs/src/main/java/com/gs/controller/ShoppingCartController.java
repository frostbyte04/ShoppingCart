package com.gs.controller;

import com.gs.domain.CartItem;
import com.gs.domain.Guitar;
import com.gs.domain.ShoppingCart;
import com.gs.domain.User;
import com.gs.service.CartItemService;
import com.gs.service.GuitarService;
import com.gs.service.ShoppingCartService;
import com.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private GuitarService guitarService;

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/cart")
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    @RequestMapping("/addItem")
    public String addItem(
            @ModelAttribute("guitar") Guitar guitar,
            @ModelAttribute("qty") String qty,
            Model model, Principal principal
    ) throws Exception {
        User user = userService.findByUsername(principal.getName());
        guitar = guitarService.findById(guitar.getId());

        if (Integer.parseInt(qty) > guitar.getInStockNumber()) {
            model.addAttribute("notEnoughStock", true);
            return "forward:/guitarDetail?id="+guitar.getId();
        }

        CartItem cartItem = cartItemService.addGuitarToCartItem(guitar, user, Integer.parseInt(qty));
        model.addAttribute("addGuitarSuccess", true);

        return "forward:/guitarDetail?id="+guitar.getId();
    }

    @RequestMapping("/updateCartItem")
    public String updateShoppingCart(
            @ModelAttribute("id") Long cartItemId,
            @ModelAttribute("qty") int qty
    ) throws Exception {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setQty(qty);
        cartItemService.updateCartItem(cartItem);

        return "forward:/shoppingCart/cart";
    }

    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") Long id) throws Exception {
        cartItemService.removeCartItem(cartItemService.findById(id));

        return "forward:/shoppingCart/cart";
    }
}
