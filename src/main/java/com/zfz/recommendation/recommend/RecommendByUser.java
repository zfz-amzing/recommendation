package com.zfz.recommendation.recommend;



import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.mapper.IBookMapper;
import com.zfz.recommendation.service.BookService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RecommendByUser {

    public  List<RecommendedItem> recommendByUser(Integer userId) throws IOException, TasteException {

        File file = new File("D:\\web\\rate.csv");
        // System.out.println(file.length());
        DataModel model = new FileDataModel(file);
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood
                = new NearestNUserNeighborhood(4, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(
                model,neighborhood,similarity
        );
        List<RecommendedItem> recommendedItems = recommender.recommend(userId,5);
        return recommendedItems;
    }
}
