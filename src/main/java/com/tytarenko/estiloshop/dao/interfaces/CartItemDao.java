package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemDao extends JpaRepository<CartItem, Long> {

    @Query(value = "INSERT INTO purchase_join_table (card_id, purchase_id) VALUES (:cartId, :purchaseId)", nativeQuery = true)
    void addCartItemToPurchase(@Param("cartId") long cartId,
                               @Param("purchaseId") long purchaseId);

}
