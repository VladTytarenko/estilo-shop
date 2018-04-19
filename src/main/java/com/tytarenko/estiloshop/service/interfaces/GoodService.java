package com.tytarenko.estiloshop.service.interfaces;

import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;

import java.awt.*;
import java.util.List;

public interface GoodService {

    void addGood(Good good);
    void updateGood(Good good);
    void deleteGood(long id);
    List<Good> getGoodsByPrice(long from, long to);
    List<Good> getGoodsBySize(List<SizeEnum> sizeList);
    List<Good> getGoodsByColor(List<Color> colorList);
}
