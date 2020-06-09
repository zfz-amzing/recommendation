package com.zfz.recommendation.service;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.mapper.IBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookMapper bookMapper;

    public List<Book> selectBookById(Integer bookId){
        List<Book> books = bookMapper.selectBookById(bookId);
        return books;
    }
    public List<Book> selectBooksByTypeId(Integer typeId){
        List<Book> books = bookMapper.selectBooksByTypeId(typeId);
        return books;
    }
    public List<Book> selectBooksByName(String name){
        String tmp = "%" + name + "%";
        List<Book> books = bookMapper.selectBooksByName(tmp);
        return books;
    }

}
