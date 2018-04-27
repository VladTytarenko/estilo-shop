package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;

import java.awt.*;
import java.util.Currency;
import java.util.List;

public interface GoodService {

    void addGood(Good good);
    void updateGood(Good good);
    void deleteGood(Long id);
    Good getGoodById(long id);
    List<Good> getAll();
    List<Good> getByFilterAsc(SizeEnum sizeEnum, long min, long max);
    List<Good> getByFilterDesc(SizeEnum sizeEnum, long min, long max);
    long getMinPrice();
    long getMaxPrice();

}
