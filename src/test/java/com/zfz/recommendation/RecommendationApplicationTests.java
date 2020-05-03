package com.zfz.recommendation;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.bean.User;
import com.zfz.recommendation.recommend.RecommendByUser;
import com.zfz.recommendation.service.BookService;
import com.zfz.recommendation.service.RecommendService;
import com.zfz.recommendation.service.UserService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootTest
class RecommendationApplicationTests {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendService recommendService;


    @Test
    void contextLoads() {
    }
    @Test
    void testFindBookById(){
        List<Book> books = bookService.selectBookById(14248);
        System.out.println(books);

    }
    @Test
    void testFindBookByTypeId(){
        List<Book> books = bookService.selectBooksByTypeId(14248);
        for (Book book : books)
            System.out.println(book);
    }
    @Test
    void recommendTest() throws IOException, TasteException {
        FileTool fileTool = new FileTool();
        fileTool.append(1,200,(double) 5);
    }
    @Test
    void readTest() throws IOException {
        FileTool fileTool = new FileTool();
        fileTool.updateRate(1,102, 1.0);
    }
    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        userService.addUser(user);
    }
    @Test
    void testSelectUserById(){

        //System.out.println(userService.selectUserById(7));

    }
    @Test
    void testRecommendByUser() throws IOException, TasteException {
        RecommendByUser recommendByUser = new RecommendByUser();
        List<Book> books = recommendService.getBookByRecommendResult(recommendByUser.recommendByUser(3));
        for (Book book : books){
            System.out.println(book);
        }

    }
    @Test
    void testSelectUser(){
        User user = new User();
        user.setUsername("zfz");
        user.setPassword("123");
        boolean b = userService.selectUserByUsernameAndPassword(user);
        System.out.println(b);
    }

}
