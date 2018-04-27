package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);
    void addToPurchase(long cardId, long purchaseId);

}
