package com.zfz.recommendation.controller;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.service.BookService;
import com.zfz.recommendation.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private RecommendService recommendService;

//    @RequestMapping("/show/{typeId}")
//    @ResponseBody
//    public ResponseMessage showAllBooks(@PathVariable Integer typeId, Model model){
//        List<Book> books = bookService.selectBooksByTypeId(typeId);
//        model.addAttribute("list",books);
//        return ResponseMessage.success().addObject("list",books);
//    }
    @RequestMapping("/show/{typeId}")
    @ResponseBody
    public Object showAllBooks(@PathVariable Integer typeId, Model model){
    List<Book> books = bookService.selectBooksByTypeId(typeId);
    model.addAttribute("list",books);
    return books;
    }
//    @RequestMapping("/recommend/{userId}")
//    @ResponseBody
//    public Object getRecommendBooks(@PathVariable Integer userId){
//        List<Book> books = recommendService.getRecommendBookByUserId(userId);
//        return books;
//    }

    /**
     * 用于加载书籍详情页面，利用一个Ajax请求到书籍详情信息和推荐图书的信息
     * @param bookId 书籍详情的id
     * @param userId 登录用户的id，根据id进行推荐
     * @return
     */
    @RequestMapping("/detail//{bookId}/{userId}")
    @ResponseBody
    public Object getBookById(@PathVariable Integer bookId,@PathVariable Integer userId){
        Map<String,List<Book>> map = new HashMap<>();
       // List<Book> books = bookService.selectBookById(bookId);
        map.put("detail",bookService.selectBookById(bookId));
        map.put("recommend",recommendService.getRecommendBookByUserId(userId));
        return map;
    }

//    @RequestMapping("/test")
//    public String test(){
//        return "showBooks";
//    }
}
