package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.CartItemDao;
import com.tytarenko.estiloshop.entity.CartItem;
import com.tytarenko.estiloshop.service.interfaces.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.saveAndFlush(cartItem);
    }

    @Override
    public void addToPurchase(long cardId, long purchaseId) {
        cartItemDao.addCartItemToPurchase(cardId, purchaseId);
    }
}
