package com.zfz.recommendation.mapper;

import com.zfz.recommendation.bean.Rate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRateMapper {
    List<Rate> hasUserRated(@Param("userId") Integer userId, @Param("bookId") Integer bookId);
    void updateRate(@Param("userId") Integer userId,@Param("bookId") Integer bookId,@Param("rate") Integer rate);
    void insertRate(@Param("userId") Integer userId,@Param("bookId") Integer bookId,@Param("rate") Integer rate);
}
