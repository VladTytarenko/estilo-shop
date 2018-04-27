package com.tytarenko.estiloshop.service;

import com.tytarenko.estiloshop.dao.interfaces.GoodDao;
import com.tytarenko.estiloshop.entity.Good;
import com.tytarenko.estiloshop.entity.SizeEnum;
import com.tytarenko.estiloshop.service.interfaces.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public void addGood(Good good) {
        goodDao.saveAndFlush(good);
    }

    @Override
    public void updateGood(Good good) {
        goodDao.saveAndFlush(good);
    }

    @Override
    public void deleteGood(Long id) {
        goodDao.deleteById(id);
    }

    @Override
    public Good getGoodById(long id) {
        return goodDao.findGoodByGoodId(id);
    }

    @Override
    public List<Good> getAll() {
        return goodDao.findAll();
    }

    @Override
    public List<Good> getByFilterAsc(SizeEnum sizeEnum, long min, long max) {
        return goodDao.filterAsc(sizeEnum, min, max);
    }

    @Override
    public List<Good> getByFilterDesc(SizeEnum sizeEnum, long min, long max) {
        return goodDao.filterDesc(sizeEnum, min, max);
    }

    @Override
    public long getMinPrice() {
        return goodDao.getMinPrice();
    }

    @Override
    public long getMaxPrice() {
        return goodDao.getMaxPrice();
    }

}
