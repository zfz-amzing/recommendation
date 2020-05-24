package com.zfz.recommendation.service;

import com.zfz.recommendation.bean.Rate;
import com.zfz.recommendation.mapper.IRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateService {
    @Autowired
    IRateMapper rateMapper;

    public boolean hasUserRated(Integer userId, Integer bookId){
        List<Rate> rates = rateMapper.hasUserRated(userId, bookId);
        for (Rate rate : rates){
            System.out.println(rate);
        }
        return rates.size() != 0;
    }
    public void updateRate(Integer userId, Integer bookId, Integer rate){
        rateMapper.updateRate(userId, bookId, rate);
    }
    public void insertRate(int userId, int bookId, int rate){
        rateMapper.insertRate(userId,bookId,rate);
    }
}
