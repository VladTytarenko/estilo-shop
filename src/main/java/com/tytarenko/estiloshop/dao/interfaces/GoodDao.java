package com.tytarenko.estiloshop.dao.interfaces;

import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface GoodDao extends JpaRepository<Good, Long> {

    List<Good> findAll();

    Good findGoodByGoodId(Long id);

    @Query("SELECT g FROM Good g WHERE g.size = :size AND g.price BETWEEN :min AND :max ORDER BY g.price ASC")
    List<Good> filterAsc(@Param("size") SizeEnum size,
                      @Param("min") long min,
                      @Param("max") long max);

    @Query("SELECT g FROM Good g WHERE g.size = :size AND g.price BETWEEN :min AND :max ORDER BY g.price DESC")
    List<Good> filterDesc(@Param("size") SizeEnum size,
                          @Param("min") long min,
                          @Param("max") long max);

    @Query("SELECT MIN(g.price) FROM Good g")
    long getMinPrice();

    @Query("SELECT MAX(g.price) FROM Good g")
    long getMaxPrice();

//    @Query(value = "INSERT INTO purchase_join_table (good_id, purchase_id) VALUES (:goodId, :purchaseId)",
//            nativeQuery = true)
//    void addToPurchase(@Param("goodId") long goodId,
//                       @Param("purchaseId") long purchaseId);
}
