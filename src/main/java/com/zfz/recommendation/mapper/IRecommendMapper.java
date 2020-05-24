package com.zfz.recommendation.mapper;

import com.zfz.recommendation.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface IRecommendMapper extends Serializable {
    void saveRecommendList(@Param("userId") Integer userId,@Param("bookId") Integer bookId);
    boolean isResultSaved(@Param("userId") Integer userId,@Param("bookId") Integer bookId);
    List<Integer> getRecommendBookId(Integer userId);

}
