package com.zfz.recommendation.service;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.mapper.IBookMapper;
import com.zfz.recommendation.mapper.IRecommendMapper;
import com.zfz.recommendation.recommend.RecommendByUser;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendService {
    @Autowired
    private IBookMapper bookMapper;
    @Autowired
    private IRecommendMapper recommendMapper;

    public List<Book> getBookByRecommendResult(List<RecommendedItem> recommendedItems){

        List<Book> result = new ArrayList<>();
        for (RecommendedItem item : recommendedItems){
            int bookId = (int)item.getItemID();
            List<Book> book = bookMapper.selectBookById(bookId);
            result.addAll(book);

        }
        return result;
    }

    public void saveRecommendList(Integer userId, Integer bookId){
        recommendMapper.saveRecommendList(userId,bookId);
    }
    public boolean isResultSaved(Integer userId, Integer bookId){
        boolean b = recommendMapper.isResultSaved(userId, bookId);
        return b;
    }

    /**
     * 从数据库读取推荐的图书
     * @param userId 被推荐用户的userId
     * @return
     */
    public List<Book> getRecommendBookByUserId(Integer userId){
        List<Integer> recommendBookId = recommendMapper.getRecommendBookId(userId);
        List<Book> books = new ArrayList<>();
        for (Integer i : recommendBookId){
            books.add(bookMapper.selectBookById(i).get(0));
        }
        return books;
    }

    /**
     * 查询阅读量最高的书籍推荐给游客
     * @return
     */
    public List<Book> selectMostViewBooks(){
        List<Book> books = bookMapper.selectMostViewBooks();
        return books;
    }

    public void recommend(Integer userId) throws IOException, TasteException {
        RecommendByUser recommendByUser = new RecommendByUser();
        List<RecommendedItem> recommendedItems = recommendByUser.recommendByUser(userId);
        List<Book> recommendBooks = this.getBookByRecommendResult(recommendedItems);
        for (Book book : recommendBooks){
            if ( !recommendMapper.isResultSaved(userId, book.getBookId()) )
                recommendMapper.saveRecommendList(userId, book.getBookId());
        }
    }

}
