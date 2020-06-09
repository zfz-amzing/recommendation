package com.zfz.recommendation;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.bean.User;
import com.zfz.recommendation.recommend.RecommendByUser;
import com.zfz.recommendation.service.BookService;
import com.zfz.recommendation.service.RateService;
import com.zfz.recommendation.service.RecommendService;
import com.zfz.recommendation.service.UserService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class RecommendationApplicationTests {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendService recommendService;
    @Autowired
    private RateService rateService;


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
        List<Book> books = bookService.selectBooksByTypeId(142);

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
        // User user1 = userService.selectUserByUsernameAndPassword(user);
        boolean test = userService.selectUserByUsername("test");
        System.out.println(test);
    }
    @Test
    void testSaveRecommend() throws IOException, TasteException {
        RecommendByUser recommendByUser = new RecommendByUser();
        List<Book> books = recommendService.getBookByRecommendResult(recommendByUser.recommendByUser(3));
        for (Book book : books){
            recommendService.saveRecommendList(3,book.getBookId());
        }
    }
    @Test
    void testIsSaved(){
        boolean resultSaved = recommendService.isResultSaved(3, 14248);
        System.out.println(resultSaved);
    }
    @Test
    void testGetRecommendById(){
        List<Book> books = recommendService.getRecommendBookByUserId(3);
        for (Book book : books){
            System.out.println(book);
        }
    }
    @Test
    void testMostView(){
        List<Book> books = recommendService.selectMostViewBooks();
        for (Book book :books){
            System.out.println(book);
        }
    }
    @Test
    public void testRate(){
        int userId = 1,bookId = 44737,rate = 1;
        boolean b = rateService.hasUserRated(userId, bookId);
        System.out.println(b);
        rateService.updateRate(userId,bookId,2);
    }
    @Test
    public void testSelectByName(){
        String bookName = "金";
        List<Book> books = bookService.selectBooksByName(bookName);
        for (Book book :books){
            System.out.println(book);
        }
    }
    @Test
    public void testRecommend() throws IOException, TasteException {
        recommendService.recommend(4);


    }
}
