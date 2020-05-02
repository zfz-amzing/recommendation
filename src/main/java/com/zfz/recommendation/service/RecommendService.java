package com.zfz.recommendation.service;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.mapper.IBookMapper;
import com.zfz.recommendation.recommend.RecommendByUser;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendService {
    @Autowired
    private IBookMapper bookMapper;

    public List<Book> getBookByRecommendResult(List<RecommendedItem> recommendedItems){

        List<Book> result = new ArrayList<>();
        for (RecommendedItem item : recommendedItems){
            int bookId = (int)item.getItemID();
            List<Book> book = bookMapper.selectBookById(bookId);
            result.addAll(book);

        }
        return result;
    }


}
