package com.zfz.recommendation;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RecommendationApplicationTests {

    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
    }
    @Test
    void testFindBookById(){
        List<Book> books = bookService.selectBookById(1);
        System.out.println(books);

    }
    @Test
    void testFindBookByTypeId(){
        List<Book> books = bookService.selectBooksByTypeId(93);
        for (Book book : books)
            System.out.println(book);
    }

}
