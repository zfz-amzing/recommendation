package com.zfz.recommendation.mapper;

import com.zfz.recommendation.bean.Book;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IBookMapper extends Serializable {

    List<Book> selectBookById(Integer bookId);
    List<Book> selectBooksByTypeId(Integer typeId);
}
