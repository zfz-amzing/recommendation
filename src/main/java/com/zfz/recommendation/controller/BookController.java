package com.zfz.recommendation.controller;

import com.zfz.recommendation.bean.Book;
import com.zfz.recommendation.bean.ResponseMessage;
import com.zfz.recommendation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

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

    @RequestMapping("/")
    public String index(){
        return "booksort";
    }
//    @RequestMapping("/test")
//    public String test(){
//        return "showBooks";
//    }
}