package com.zfz.recommendation.mapper;

import com.zfz.recommendation.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRecommendMapper {
    void saveRecommendList(@Param("userId") Integer userId,@Param("bookId") Integer bookId);
    boolean isResultSaved(@Param("userId") Integer userId,@Param("bookId") Integer bookId);
    List<Integer> getRecommendBookId(Integer userId);

}
